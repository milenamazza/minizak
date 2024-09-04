package it.uniroma1.textadv.eccezioni.notCompatibleException;

/**
 * La classe gestice l'eccezione generata quando si
 * tenta di utilizzare un elemento vuoto
 */
public class EmptyObjectException extends NotCompatibleException {

	private final static String errore = " è vuoto";
	private Object o;
	
	/**
	 * Costruttore dell'eccezione
	 * @param o: elemento vuoto
	 */
	public EmptyObjectException(Object o) {
		this.o = o;
	}
	
	@Override
	public String getMessage()
	{
		return o.toString() + errore;
	}
}
