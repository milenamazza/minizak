package it.uniroma1.textadv.links;

import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.interfacce.Prendibile;

/**
 * La classe modella il @Links Slitta
 * e inoltre implementa l'interfaccia @Prendibile
 *
 */
public class Slitta extends Links implements Prendibile {
	
	/**
	 * Costruttore della classe
	 * @param name: nome da associare al @Links
	 * @param parametro
	 */
	public Slitta(String name, String[] parametro) {
		super(name, parametro);
		setOpen();
	}
	
	/**
	 * mappa il metodo prendi() a quello vai()
	 */
	@Override
	public void prendi() throws LockedException
	{
		this.vai();
	}
}
