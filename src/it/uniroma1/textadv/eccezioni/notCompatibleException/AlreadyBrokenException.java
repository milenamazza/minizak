package it.uniroma1.textadv.eccezioni.notCompatibleException;
/**
 * La classe gestice l'eccezione generata quando si tenta di 
 * rompere un elemento già rotto
 *
 */
public class AlreadyBrokenException extends NotCompatibleException {
	
	private final static String errore = " è già rotto";
	private Object o;
	
	/**
	 * Costruttore dell'eccezione
	 * @param o: elemento già rotto
	 */
	public AlreadyBrokenException(Object o) {
		this.o = o;
	}
	
	@Override
	public String getMessage()
	{
		return o.toString() + errore;
	}
}
