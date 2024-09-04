package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.eccezioni.notCompatibleException.NotCompatibleException;
import it.uniroma1.textadv.eccezioni.notTakeableException.NotTakeableException;
import it.uniroma1.textadv.eccezioni.notTakeableException.protectedByException;
import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Prendibile;
import it.uniroma1.textadv.interfacce.Protetto;
import it.uniroma1.textadv.interfacce.Scioglibile;
import it.uniroma1.textadv.interfacce.Usabile;

/**
 * modella la classe Fiammifero
 * @author milli
 *
 */
public class Fiammifero extends Objects implements Prendibile, Inventabile, Usabile, Protetto {

	private boolean protetto = true;
	
	/**
	 * Costruttore della classe Fiammifero
	 * @param name: nome da associare all'oggetto
	 * @param parametro
	 */
	public Fiammifero(String name, String[] parametro) {
		super(name, parametro);
	}
	/**
	 * permette di prendere l'oggetto se esso non è protetto
	 */
	@Override
	public void prendi() throws NotTakeableException
	{	
		if(!protetto)
			this.inventa();
		else
			throw new protectedByException(this);
	}

	/**
	 * 
	 * getter del campo: protetto
	 */
	public boolean isProtetto() {
		return protetto;
	}
	/**
	 * 
	 * setter del campi: protetto
	 */
	private void setProtetto(boolean protetto) {
		this.protetto = protetto;
	}
	
	/**
	 * rende possibile prendere l'oggetto
	 */
	@Override
	public void setPrendibile() {
		setProtetto(false);
	}
	
	/**
	 * permette di usare l'oggetto su oggetti che implementano l'interfaccia @Sciioglibile
	 */
	@Override
	public void usa(Objects o) throws NotCompatibleException 
	{
		if (o instanceof Scioglibile)
			((Scioglibile)o).sciogli();
		else
			throw new NotCompatibleException();
	}

}
