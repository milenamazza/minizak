package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Openable;
import it.uniroma1.textadv.interfacce.Prendibile;
import it.uniroma1.textadv.interfacce.Usabile;
import it.uniroma1.textadv.links.Links;

/**
 *  Classe per modellare l'oggetto chaive
 *
 */
public class Chiave extends Objects implements Prendibile, Inventabile, Usabile {

	/**
	 * Costruttore dell'oggetto
	 * @param nome: nome associato all'oggetto
	 * @param parametro
	 */
	public Chiave(String nome, String[] parametro) {
		super(nome, parametro);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * mette l'oggetto nell'inventario
	 */
	@Override
	public void prendi()
	{
		this.inventa();
	}
	
	/*
	 * utilizza l'oggetto sul un Link l
	 */
	@Override
	public void usa(Links l) throws LockedException
	{
		l.apriCon(this);
	}

}
