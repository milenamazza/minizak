package it.uniroma1.textadv;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import it.uniroma1.textadv.Aperture.Chiuso;
import it.uniroma1.textadv.characters.Characters;
import it.uniroma1.textadv.eccezioni.creazione.AlreadyPositioned;
import it.uniroma1.textadv.eccezioni.creazione.CreationalException;
import it.uniroma1.textadv.eccezioni.creazione.DoulbePlayerException;
import it.uniroma1.textadv.eccezioni.creazione.EqualNameException;
import it.uniroma1.textadv.factories.Factory;
import it.uniroma1.textadv.links.Links;
import it.uniroma1.textadv.objects.Objects;

/**
 *  classe utilizzata per salvare gli oggetti che andranno a creare il mondo
 */
public class WorldBuilder 
{
	private static final int ZERO = 0;
	private static final int UNO = 1;
	private static final int DUE = 2;
	
	public Map<String,Objects> objects;
	public Map<String,Characters> characters;
	public Map<String,Links> links;
	static Map<String,Room> rooms;
	private Player player;
	public static Map<Objects, String> parametri;
	public Map<Room, String[]> collegamenti;
	
	/**
	 * Costruttore della classe
	 */
	public WorldBuilder()
	{
		objects = new HashMap<>();
		characters = new HashMap<>();
		links = new HashMap<>();
		rooms = new HashMap<>();
		parametri = new HashMap<>();
		collegamenti = new HashMap<>();
	}
	
	/**
	 *  gestisce la creazione degli @Objects, dei @Characters e dei @Links
	 * @param <T> Classe degli elementi creati
	 * @param e: enumerazione del tipo di elemento
	 * @param blocco: List<String> blocco di testo da analizzare
	 * @param factory: factory appropriata per la creazione
	 * @CreationalException: solleva eccezione in caso di problemi di creazione
	 */
	public <T> void create(Elementi e, List<String> blocco, Factory factory) throws CreationalException
	{
		String testo = blocco.get(ZERO);
		String[] array = Arrays.copyOfRange(testo.split("\n"), UNO, testo.split("\n").length);
		try {
				Field c = WorldBuilder.class.getDeclaredField(e.toString().toLowerCase());
				Map<String, T> dizionario = (Map<String,T>) c.get(this);
				
				for (String riga : array)
				{
					if(riga.contains("//")) 										// ignore comments
						riga = riga.substring(ZERO,riga.indexOf("//")).strip();
					
					String[] parametri = riga.split("\\t");
					String nome = parametri[ZERO];
					String classe = parametri[UNO];
					
					if (dizionario.containsKey(nome))
						throw new EqualNameException();
					else
					{
						if (parametri.length == DUE)
							dizionario.put(nome,  factory.get(nome, classe, null));
						else
							dizionario.put(nome,factory.get(nome, classe, Arrays.copyOfRange(parametri,DUE,parametri.length)));
					}
				}
				
				if(e.equals(Elementi.LINKS))
					impostaParametri();		
				
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e1) {
			throw new CreationalException();
		}
	}
	
	
	/**
	 * creation of rooms
	 * @param blocco: List<String> blocco da cui trarre informazioni
	 * @throws CreationalException: solleva eccezione in caso di problemi di creazione
	 */
	public void createRooms(List<String> blocco) throws CreationalException
	{
		List<String[]> stanze = blocco.stream()
				.map(x -> x.split("\\n"))
				.collect(Collectors.toList());

		for(String[] camera : stanze)
		{
			List<String[]> info = Arrays.stream(camera)
					.map(x -> x.split("\\t"))
					.collect(Collectors.toList());
			
			String name = getRoomName(info);
			Room room = new Room(name, info.get(UNO)[UNO]);
			
			for(int i = DUE; i < info.size(); i++)
			{
				if (info.get(i).length == UNO)
					continue;
				
				String classe = info.get(i)[ZERO];
				String[] dati = info.get(i)[UNO].split(",");
				
				try {
					Method m = Room.class.getMethod(classe + "Add", String[].class,  WorldBuilder.class);
					Object[] array = new Object[] {dati, this};
					m.invoke(room, array);
				
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					System.out.println(e.getCause().getMessage());
					throw new CreationalException();
				}
			}	
			if ((rooms.containsKey(room.getName())))
				throw new EqualNameException();
			else
				rooms.put(room.getName(), room);	
		}
		rooms.values().forEach(x->{
			try {
				x.setLinks(this);
			} catch (CreationalException e) {
				e.printStackTrace();
			}
		});
	}
	
	/**
	 * creazione del mondo
	 * @param blocco: List<String> blocco da cui trarre informazioni
	 * @return restituisce un oggetto di tipo mondo
	 */
	public Mondo buildWorld(List<String> blocco){
		String[] s = blocco.get(ZERO).split("\\n");
		String name = s[ZERO].substring(s[ZERO].indexOf(":")+UNO,s[ZERO].length()-UNO);
		String description = s[UNO].split("\\t")[UNO];
		Room start = rooms.get(s[DUE].split("\\t")[UNO]);
		
		Mondo m = Mondo.getMondo(name, description, start);
		rooms.values().forEach(x->m.addRoom(x));
		m.setPlayer(player);
		
		return m;
	}
	
	/**
	 * creazione del personaggio
	 * @param blocco
	 * @CreationalException: solleva eccezione in caso di problemi di creazione
	 */
	public void createPlayer(List<String> blocco) throws CreationalException
	{
		String nome = blocco.get(ZERO).split("\\t")[ZERO];
		if(Player.getIstance()!=null)
			new DoulbePlayerException();
		player = Player.getIstance(nome);
	}
	
	/**
	 * Metodo privato per impostare i parametri dei @Links e degli @Objects
	 * @throws AlreadyPositioned: solelva un'eccezione se si richiede di
	 * mettere lo stesso oggetto in più punti del mondo
	 */
	private void impostaParametri() throws AlreadyPositioned
	{
		parametri.entrySet().forEach((x)->{
			if(links.containsKey(x.getValue()))
			{
				Links l = links.get(x.getValue());
				l.setKey(x.getKey());
				l.setApertura(new Chiuso());
			}
		});
		for(Objects o: objects.values())
			o.setOggetto(this);
		
	}
	
	/**
	 * Restituisce il nome della camera a partire dalle informazioni
	 * su di essa
	 * @param info
	 * @return
	 */
	private String getRoomName(List<String[]> info)
	{
		return info.get(ZERO)[ZERO].substring(info.get(ZERO)[ZERO].indexOf(":")+UNO,info.get(ZERO)[ZERO].length()-UNO);
	}

}
