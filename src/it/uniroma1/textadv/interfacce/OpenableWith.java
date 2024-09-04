package it.uniroma1.textadv.interfacce;

import it.uniroma1.textadv.eccezioni.openingException.KeyNotNeededException;
import it.uniroma1.textadv.eccezioni.openingException.OpeningException;

/**
 * Interfaccia implementata dagli elementi x che rendono valido
 * il comando in input "apri x con" cioè che possono essere aperti con un oggetto
 *
 */
public interface OpenableWith 
{
	/**
	 * il metodo permette di aprire l'Openable attraverso l'elemento
	 * contenuto nella stringa, se esso è posseduto dal giocatore
	 * @param s
	 * @throws OpeningException: solleva un'eccezione nel caso 
	 * in cui non sia possibile aprire l'elemento, la chiave è 
	 * errata o non posseduta dal giocatore
	 */
	void apriCon(String s) throws OpeningException;
	
	/**
	 * rende aperto l'elemento
	 */
	void setOpen();
}
