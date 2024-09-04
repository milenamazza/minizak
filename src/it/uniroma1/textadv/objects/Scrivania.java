package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.Aperture.Apertura;
import it.uniroma1.textadv.Aperture.AperturaSemplice;
import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.eccezioni.openingException.OpeningException;
import it.uniroma1.textadv.interfacce.Openable;

/**
 * classe che permette di modellare l'oggetto Scrivania
 *
 */
public class Scrivania extends Objects implements Openable {
	private boolean open = false;
	private Apertura apertura = new AperturaSemplice();

	/**
	 * costruttore
	 * @param nome: nome dell'oggetto
	 * @param parametro
	 */
	public Scrivania(String nome, String[] parametro) {
		super(nome, parametro);
	}

	/**
	 * Override: restituisce una descrizione differente se l'oggetto è aperto o chiuso
	 */
	@Override
	public String getDescription()
	{
		if (!isOpen() || getOggetto()==null)
		{
			return super.getDescription();
		}
		
		else
		{
			return super.getDescription() + "\n" + "Gli oggetti all'interno della scrivania sono: " + oggetto.getName();
		}
	}
	
	/**
	 * apre la scrivania
	 */
	@Override
	public void apri() throws OpeningException 
	{
		apertura.open(this);
	}

	/**
	 * imposta la variabile di apertura a true
	 */
	@Override
	public void setOpen() {
		open = true;	
	}

	/**
	 * getter di open
	 */
	@Override
	public boolean isOpen() {
		return open;
	}

	/**
	 * setter di open
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}
}
