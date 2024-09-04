package it.uniroma1.textadv.eccezioni.notTakeableException;


/**
 * La classe gestice l'eccezione generata quando si 
 * tenta di prendere un oggetto non ancora pagato
 *
 */
public class NotPayedException extends NotTakeableException {
	
	private final static String errore = "Bisogna pagare:";
	private Object o;
	
	/**
	 * Costruttore dell'eccezione
	 * @param o: elemento non ancora pagato
	 */
	public NotPayedException(Object o) {
		this.o = o;
	}
	
	@Override
	public String getMessage()
	{
		return errore + o.toString();
	}

}
