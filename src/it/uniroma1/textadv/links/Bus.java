package it.uniroma1.textadv.links;

import it.uniroma1.textadv.Aperture.Apertura;
import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.interfacce.Openable;
import it.uniroma1.textadv.interfacce.Prendibile;

/**
 * La classe modella il @Links bus
 * e implementa inoltre l'interfaccia @Prendibile
 */
public class Bus extends Links implements Prendibile {

	/**
	 * Costruttore del @Link
	 * @param name: nome da associare al link
	 * @param parametro
	 */
	public Bus(String name, String[] parametro) {
		super(name, parametro);
		setOpen();
	}
	
	/**
	 * Il metodo mappa il metodo prendi() a quello vai()
	 * della stessa classe
	 */
	@Override
	public void prendi() throws LockedException
	{
		this.vai();
	}
}
