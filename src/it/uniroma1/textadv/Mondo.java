package it.uniroma1.textadv;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import it.uniroma1.textadv.characters.Characters;
import it.uniroma1.textadv.factories.*;
import it.uniroma1.textadv.factories.ObjectsFactory;
import it.uniroma1.textadv.links.Links;
import it.uniroma1.textadv.objects.Objects;


/**
 * classe adibita alla lettura del file e alla creazione del mondo
 * @author milli
 *
 */
public class Mondo {

	public static Mondo mondo;
	private String name;
	private String description;
	private Room room;
	private HashSet<Room> rooms = new HashSet<Room>();
	private Player player;
	private boolean vittoria;
	
	/**
	 * legge il file, lo divide in settori in base e richiama su ciascun settore la factory corretta.
	 * Per creare il mondo si utilizza il Build Creation Pattern
	 * @param nomeFile
	 * @return Mondo
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	public static Mondo fromFile(String nomeFile) {		
		
		WorldBuilder w = new WorldBuilder();
		Map<Elementi,ArrayList<String>> blocchiEsecuzione = Tokenizer.read(nomeFile);
		List<Elementi> array = List.of(Elementi.OBJECTS,Elementi.CHARACTERS, Elementi.LINKS, Elementi.ROOM, Elementi.PLAYER, Elementi.WORLD);
		try
		{
			for(Elementi s : array) {
				switch(s) {
				case OBJECTS -> {w.create(s, blocchiEsecuzione.get(s), new ObjectsFactory());}
				case CHARACTERS-> {w.create(s, blocchiEsecuzione.get(s), new CharactersFactory());}
				case LINKS -> {w.create(s, blocchiEsecuzione.get(s), new LinksFactory());}
				case ROOM -> {w.createRooms(blocchiEsecuzione.get(s));}
				case PLAYER -> {w.createPlayer(blocchiEsecuzione.get(s));}
				case WORLD -> {mondo = w.buildWorld(blocchiEsecuzione.get(s));}
				}
			 }
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mondo;
	}
	
	/**
	 * costruttore privato del mondo
	 * @param name: nome del mondo
	 * @param description: descrizione del mondo
	 * @param startRoom: stanza di inizio
	 */
	private Mondo(String name, String description, Room startRoom) 
	{
		this.name = name;
		this.description = description;
		this.room = startRoom;
	}
	
	/**
	 * restituisce l'istanza di mondo se essa esiste, altrimenti la crea
	 * @param name: nome del mondo
	 * @param description: descrizione del mondo
	 * @param startRoom: stanza di inizio
	 * @return
	 */
	public static Mondo getMondo(String name, String description, Room startRoom) {
		 if (mondo == null)
	        mondo = new Mondo(name, description, startRoom);		 
	     return mondo;
	}
	
	/**
	 * metodo getter della variabile name
	 * @return Stringa name
	 */
	public String getName() { return name; }
	
	/**
	 * metodo getter della variabile description
	 * @return Stringa descrioption
	 */
	public String getDescription(){return description; }
	
	/**
	 * aggiunge una camera all'hashset delle camere
	 * @param stanza
	 */
	public void addRoom(Room stanza) { rooms.add(stanza); }
	
	/**
	 * metodo getter dell'hashset delle camere
	 * @return rooms: HashSet<Room>
	 */
	public HashSet<Room> getRooms() {
		return rooms;
	}
	
	public Room getRoom(){return room;}
	
	/**
	 * definisce chi sarà il giocatore del mondo
	 * @param player
	 */
	public void setPlayer(Player player) { this.player = player; }
	
	/**
	 * cambia il riferimento alla camera in cui si trova il personaggio
	 * @param room
	 */
	public void setRoom(Room room) { this.room = room; }

	/**
	 * metodo setter della variabile vittoria
	 * @param b: valore booleano
	 */
	public void setVittoria(boolean b)
	{
		vittoria = b;
	}
	
	/**
	 * metodo getter della variabile vittoria
	 * @return il valore della variabile vittoria
	 */
	public boolean getVittoria()
	{
		return vittoria;
	}
	
	/**
	 * override del metodo toString()
	 */
	@Override
	public String toString() { return description + '\n' + room.toString() + '\n' + rooms.toString(); }
	
}
