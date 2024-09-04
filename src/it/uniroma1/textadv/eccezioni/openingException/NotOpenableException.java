package it.uniroma1.textadv.eccezioni.openingException;

/**
 * La classe gestice l'eccezione generata quando si
 * tenta di aprire un elemento che non implementa
 * l'interfaccia @Openable
 *
 */
public class NotOpenableException extends Exception {
	
	private final String errore = "Non è possibile aprire l'oggetto";
	
	@Override
	public String getMessage() { return errore; }
}
