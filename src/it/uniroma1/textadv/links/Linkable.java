package it.uniroma1.textadv.links;

import it.uniroma1.textadv.Room;
import it.uniroma1.textadv.eccezioni.openingException.LockedException;

/**
 * Interfaccia che modella tutti gli oggetti che si comportano come collegamenti
 *
 */
public interface Linkable 
{
	/**
	 * Il metodo permette al giocatore di spostarsi da una camera
	 * a quella associata alla direzione richiesta dal giocatore
	 * @throws LockedException: solleva un'eccezione nel caso in cui 
	 * l'accesso sia bloccato
	 */
	void vai() throws LockedException;
}
