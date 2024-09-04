package it.uniroma1.textadv.interfacce;

import it.uniroma1.textadv.eccezioni.notTakeableException.NotTakeableException;
import it.uniroma1.textadv.eccezioni.openingException.LockedException;

/**
 * Interfaccia implementata dagli elementi x che rendono valido
 * il comando in input "prendi x" cioè possono essere presi
 *
 */
public interface Prendibile {
	/**
	 * Il @Prendibile viene preso: 
	 * nel caso in cui si tratta di un @Links, viene mappato a vai()
	 * nel caso in cui si tratta di un @Objects, viene messo nell'inventario
	 * @throws NotTakeableException: L'elemento non può essere preso
	 * @throws LockedException: solleva un'eccezioen se l'elemento è chiuso
	 */
	void prendi() throws NotTakeableException, LockedException;
}
