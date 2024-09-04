package it.uniroma1.textadv.interfacce;

import it.uniroma1.textadv.eccezioni.notCompatibleException.AlreadyBrokenException;

/**
 * Interfaccia implementata da oggetti che possono essere rotti
 *
 */
public interface Rompibile {

	/**
	 * L'elemento viene rotto
	 * @throws AlreadyBrokenException: si solleva un'eccezione nel caso in cui
	 * l'elemento sia già stato rotto
	 */
	void rompi() throws AlreadyBrokenException;
}
