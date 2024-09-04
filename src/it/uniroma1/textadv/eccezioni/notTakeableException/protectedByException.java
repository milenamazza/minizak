package it.uniroma1.textadv.eccezioni.notTakeableException;

/**
 * La classe gestice l'eccezione generata quando si tenta di prendere un 
 * elemento che implementa l'interfaccai @Protetto
 *
 */
public class protectedByException extends NotTakeableException {
	
	private final static String errore = " è protetto";
	private Object o;
	
	/**
	 * Costruttore dell'eccezione
	 * @param o: elemento protetto
	 */
	public protectedByException(Object o) {
		this.o = o;
	}
	
	@Override
	public String getMessage()
	{
		return o.toString() + errore ;
	}

}
