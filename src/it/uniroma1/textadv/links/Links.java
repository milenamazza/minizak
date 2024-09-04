package it.uniroma1.textadv.links;

import java.util.Comparator;

import it.uniroma1.textadv.Mondo;
import it.uniroma1.textadv.Player;
import it.uniroma1.textadv.Room;
import it.uniroma1.textadv.Aperture.Apertura;
import it.uniroma1.textadv.Aperture.AperturaSemplice;
import it.uniroma1.textadv.eccezioni.creazione.CreationalException;
import it.uniroma1.textadv.eccezioni.openingException.KeyNotNeededException;
import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.eccezioni.openingException.OpeningException;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Openable;
import it.uniroma1.textadv.interfacce.OpenableWith;
import it.uniroma1.textadv.interfacce.Usabile;
import it.uniroma1.textadv.objects.Chiave;
import it.uniroma1.textadv.objects.Objects;

/**
 * classe che modella i possibili link presenti le gioco ed implementa
 * l'interafaccia @Linkable che permette agli oggetti di fungere da collegamenti
 *
 */
public abstract class Links implements Linkable, Openable, OpenableWith{

	private String name;
	private String room1;
	private String room2;
	private Room r1;
	private Room r2;
	private Objects key;
	protected Apertura apertura;
	private boolean open;
	
	/**
	 * costruttore della classe tramite nome e un array contente le stringhe dei nomi delle camere
	 * @param name
	 * @param parametro
	 */
	public Links(String name, String[] parametro)
	{
		this.name = name;
		this.room1 = parametro[0];
		this.room2 = parametro[1];
		apertura = new AperturaSemplice();
	}
	
	/**
	 * ricollega al link i riferimenti delle camere ad esso associate
	 * @param room: stanza da aggiungere
	 * @throws CreationalException: nel caso in cui le informazioni del file non siano coerenti
	 */
	public void addRoom(Room room) throws CreationalException
	{
		if (room1.equals(room.getName()))
			r1 = room;
		else if (room2.equals(room.getName()))
			r2 = room;
		else
			throw new CreationalException();
	}
	
	/**
	 * il metodo consente al giocatore di spostarsi nell'altra camera associata al link
	 */
	@Override
	public void vai() throws LockedException
	{
		if (isOpen())
		{ 
			Room camera = Mondo.mondo.getRoom().equals(r1)? r2 : r1;
			Mondo.mondo.setRoom(camera);
		}
		else
		{
			throw new LockedException();
		}
	}
	
	/**
	 * permette di aprire il link con la sua specifica apertura 
	 */
	@Override
	public void apri() throws OpeningException 
	{
		apertura.open(this);
	}
	
	/**
	 * permette di aprire il link con un oggetto, prende in input la sezione di stringa che contiene l'elemento con 
	 * cui si cerca di aprire il link
	 */
	public void apriCon(String comando) throws OpeningException 
	{
		apertura.openWith(comando, key, this);
	}
	
	/**
	 * Metodo per aprire il Link con una Chiave
	 * @param k: oggetto appertenente alla classe Chiave
	 * @throws LockedException: Viene sollevata un'eccezione se la chiave è errata
	 */
	public void apriCon(Chiave k) throws LockedException
	{
		if(k.getName().equals(key.getName()))
				setOpen();
	}
	
	/**
	 * metodo getter del campo open
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * imposta a true il campo che definisce se un Link è aperto
	 */
	@Override
	public void setOpen() {
		open = true;	
	}

	/**
	 * metodo getter del campo name
	 * @return restituisce una stringa, il valore di name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * metodo getter del campo key
	 * @return valore di key
	 */
	public Objects getKey() {
		return key;
	}

	/**
	 * metodo setter del campo key
	 * @param key: il parametro è un Objects usato come chiave per il Link
	 */
	public void setKey(Objects key) {
		this.key = key;
	}

	/**
	 * getter per il campo apertura
	 */
	public Apertura getApertura() {
		return apertura;
	}

	/**
	 * setter del campo apertura
	 */
	public void setApertura(Apertura apertura) {
		this.apertura = apertura;
	}

	/**
	 * Override del metodo toString della classe Object
	 */
	@Override
	public String toString()
	{
		return name;
	}
}
