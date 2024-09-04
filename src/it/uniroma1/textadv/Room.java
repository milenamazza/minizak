package it.uniroma1.textadv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import it.uniroma1.textadv.characters.Characters;
import it.uniroma1.textadv.eccezioni.creazione.AlreadyPositioned;
import it.uniroma1.textadv.eccezioni.creazione.CreationalException;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.links.Linkable;
import it.uniroma1.textadv.objects.Objects;

/**
 * Classe che va a rappresentare le singole stanze che vanno a formare il mondo 
 *
 */
public class Room implements Linkable{
	
	private String name;
	private String description;
	private ArrayList<Objects> objectsList = new ArrayList<Objects>();
	private ArrayList<Characters> charactersList = new ArrayList<Characters>(); 
	private Map<Direzione, Linkable> linksMap = new HashMap<>();
	
	
	/**
	 * costruttore della classe
	 * @param nome
	 * @param descrizione
	 */
	public Room(String nome, String descrizione) 
	{
		name = nome;
		description = descrizione;
	}
	
	/**
	 * metodo getter che reatituisce il nome
	 */
	public String getName() {
		return name; 
	}
	
	/**
	 * metodo getter che restituisce gli oggetti presenti nella camera
	 */
	public ArrayList<Objects> getObjectsList() { return objectsList; }


	/**
	 * metodo che restituisce i personaggi presenti nella camera
	 */
	public ArrayList<Characters> getCharactersList() { return charactersList; }
	
	/**
	 * metodo che restituisce i collegamenti della camera
	 */
	public Map<Direzione,Linkable> getLinksList() { return linksMap; }
	
	/**
	 * restitisce la descrizione della camera
	 */
	public String getDescription() { return description; }


	
	
	/**
	 * metodo destinato all'aggiunta di un oggetto nella camera
	 * @param oggetto: oggetto da aggiungere
	 */
	public void addObject(Objects oggetto) { objectsList.add(oggetto); }


	/**
	 * metodo destinato all'aggiunta di un personaggio nella camera
	 * @param personaggio: personaggio da aggiungere
	 */
	public void addCharacter(Characters personaggio) {
		charactersList.add(personaggio);
	}

	/**
	 * metodo destinato all'aggiunta di un collegamento
	 * @param @Link: link da associare alla camera
	 * @param d: direzione a cui associare il link
	 */
	public void addLink(Linkable link, Direzione d) {
		linksMap.put(d, link);
	}
	
	
	//metodi dedicati alla reflection e alla creazione del mondo
	/**
	 * inserisce l'oggetto nella camera al momento di creazione, se questo non è presente
	 * nella mappa del WorlBuilder assoliat allora solleva un errore di creazione
	 * @param oggetti: oggetti da aggiungere passati come stringa
	 * @param wb: builder del mondo
	 * @throws CreationalException: errore di creazione del mondo
	 */
	public void objectsAdd(String[] oggetti, WorldBuilder wb) throws CreationalException
	{
		for(String oggetto : oggetti)
		{
			Objects o = wb.objects.get(oggetto.strip());
			if (o!=null)
			{
				addObject(o);
				wb.objects.remove(oggetto.strip());
			}
			else
				throw new AlreadyPositioned();
		}
	}
	
	/**
	 * Definisce i link della camera
	 * @param links: array di links passati come stinga
	 * @param wb: builder del mondo
	 */
	public void linksAdd(String[] links, WorldBuilder wb)
	{
		wb.collegamenti.put(this, links);
	}
	
	/**
	 * inserisce un personaggio nella camera al momento di creazione, se questo non è presente
	 * nella mappa del WorlBuilder assoliat allora solleva un errore di creazione
	 * @param characters: array di personaggi passati per stringa
	 * @param wb: builder del mondo
	 * @throws CreationalException: errore di creazione del mondo
	 */
	public void charactersAdd(String[] characters,  WorldBuilder wb) throws CreationalException
	{
		for (String c : characters)
		{
			Characters ch = wb.characters.get(c.strip());
			if (ch!=null)
			{
				addCharacter(ch);
				wb.characters.remove(c.strip());
			}
			else
				throw new AlreadyPositioned();
		}
	}
	
	/**
	 * permette di associare alla camera i suo link e ai link associa le rispettive camere
	 * @param wb: builder del mondo
	 * @throws CreationalException: errore di creazione del mondo
	 */
	public void setLinks(WorldBuilder wb) throws CreationalException
	{
		for(String stringa : wb.collegamenti.get(this))
		{
			String[] elementi = stringa.split(":");
			if (wb.links.get(elementi[1]) != null) 
			{
				addLink(wb.links.get(elementi[1]),Direzione.valueOf(elementi[0]));
				wb.links.get(elementi[1]).addRoom(this);
			}
			else
				addLink(WorldBuilder.rooms.get(elementi[1]),Direzione.valueOf(elementi[0]));
		}
	}
	
	/**
	 * Sovrascrive il metodo dell'interfaccia @Linkable
	 */
	@Override
	public void vai() { Mondo.mondo.setRoom(this);}
	
	/**
	 * Override del metodo equals per la classe Room
	 */
	@Override 
	public boolean equals(Object ob) {
		if (ob == null)
			return false;
		if(ob instanceof Room) 
		{
			Room stanza = (Room) ob;
			return stanza.name.equals(this.name);
		}else {	return false; }
	}
	
	@Override
	public int hashCode() {
		return java.util.Objects.hash(name);
	}
	
	/**
	 * sovrascrive il metodo per la classe Room
	 */
	@Override
	public String toString() { return name; }
	
	/**
	 * controlla se il persanggio contenuto nella stringa 
	 * è presente nella camera, in caso positivo lo restituisce
	 * @param comando: stringa in input
	 * @return personaggio presente nella stringa
	 */
	public static Characters getCharacter(String comando)
	{
		return Mondo.mondo.getRoom().getCharactersList().stream()
		 .filter(x->comando.contains(x.toString()))
		 .max(Comparator.comparing(x->x.toString().length()))
			.orElse(null);
	}

	/**
	 * controlla se il Linkable contenuto nella stringa 
	 * è presente nella camera, in caso positivo lo restituisce
	 * @param comando: Stringa in input
	 * @return Linkable presente nella stringa
	 */
	public static Linkable getLinkable(String comando)
	{
		return Mondo.mondo.getRoom().getLinksList().values()
		.stream()
		.filter(x -> comando.contains(x.toString()))
		.max(Comparator.comparing(x->x.toString().length()))
		.orElse(null);
	}
	
	/**
	 * controlla se l'oggetto contenuto nella stringa 
	 * è presente nella camera, in caso positivo lo restituisce
	 * @param comando: Stringa in input
	 * @return Oggetto presente nella stringa
	 */
	public static Objects getObject(String comando)
	{
		return Mondo.mondo.getRoom().getObjectsList()
		.stream()
		.filter(x -> comando.contains(x.toString()))
		.max(Comparator.comparing(x->x.toString().length()))
		.orElse(null);
	}

	/**
	 * elimina l'elemento dalla camera
	 * @param inventabile: elemento da eleiminare
	 */
	public void elimina(Inventabile inventabile) {
		if(getCharactersList().contains(inventabile))
		{
			getCharactersList().remove((Characters) inventabile);
		}
		else if(getObjectsList().contains(inventabile))
		{
			getObjectsList().remove(inventabile);
		}
		else if(getObjectsList().stream().map(Objects::getOggetto).collect(Collectors.toList()).contains(inventabile))
		{
			for(Objects o : getObjectsList())
			{
				if (o != null)
				{
					if(o.getOggetto().toString().equals(inventabile.toString()))
					{
						o.changeObject(null);
						return;
					}
				}
			}
		}
	}
	
	
}
