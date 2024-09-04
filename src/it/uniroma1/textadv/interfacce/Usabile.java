package it.uniroma1.textadv.interfacce;

import it.uniroma1.textadv.eccezioni.notCompatibleException.NotCompatibleException;
import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.links.Links;
import it.uniroma1.textadv.objects.Objects;

/**
 * Interfaccia implementata dagli elementi x che rendono valido
 * il comando in input "usa x"
 *
 */
public interface Usabile {
	
	/**
	 * Permette di usare l'elemento su un @Objects o
	 * @param o: Oggetto su cui viene usato l' @Usabile
	 * @throws NotCompatibleException: viene sollevata un'eccezione
	 * nel caso l' @Usabile non possa essere utilizzato su o
	 */
	default public void usa(Objects o) throws NotCompatibleException {};

	/**
	 * Permette di usare l'elemento su un @Links o
	 * @param l: link su cui viene usato l' @Usabile
	 * @throws LockedException: viene sollevata un'eccezione se
	 * l' @Usabile non consente di aprire il link
	 */
	default public void usa(Links l) throws LockedException {};
}
