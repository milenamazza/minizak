package it.uniroma1.textadv.interfacce;

import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.eccezioni.openingException.OpeningException;

/** 
 * Interfaccia implementata dagli elementi x che rendono valido
 * il comando in input "apri x" cioè che possono essere aperti
 */
public interface Openable 
{	
	/**
	 *  metodo che permette di capire se L'Openable è già aperto
	 */
	boolean isOpen();
	
	/**
	 * il metodo permette di aprire l'elemento
	 * @throws OpeningException: solleva un'eccezione nel caso 
	 * in cui non sia possibile aprire l'elemento
	 */
	void apri() throws OpeningException;
	
	/**
	 * rende aperto l'elemento
	 */
	void setOpen();
}
