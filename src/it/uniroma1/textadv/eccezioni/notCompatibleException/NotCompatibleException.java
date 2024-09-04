package it.uniroma1.textadv.eccezioni.notCompatibleException;

/**
 *  La classe gestice l'eccezione generata quando 
 *  si tenta di usare due elementi non compatibili tra loro
 */
public class NotCompatibleException extends Exception {
	
	public static final String e = "Gli oggetti non sono compatibili";
	
	@Override
	public String getMessage()
	{
		return e;
	}
}
