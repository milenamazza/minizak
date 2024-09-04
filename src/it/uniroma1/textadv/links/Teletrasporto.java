package it.uniroma1.textadv.links;

import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.eccezioni.openingException.OpeningException;
import it.uniroma1.textadv.objects.Chiave;

/**
 * La classe modella il @Links Teletrasporto
 *
 */
public class Teletrasporto extends Links {

	/**
	 * Costruttore della classe
	 * @param name: nome da ssociare al @Links
	 * @param parametro
	 */
	public Teletrasporto(String name, String[] parametro) {
		super(name, parametro);
	}

	/**
	 * il Teletrasporto viene utilizzato in automatico,
	 * non appena esso viene aperto
	 */
	@Override
	public void apriCon(Chiave k) throws LockedException 
	{
		super.apriCon(k);
		if(isOpen())
			vai();
	}
	
}
