package it.uniroma1.textadv.eccezioni;

/**
 * La classe gestice l'eccezione generata quando un comando
 * non è formulato nella maniera corretta
 *
 */
public class NotLegalCommandException extends Exception {

private final String errore = "Il comando non è valido";
	
	@Override
	public String getMessage() { return errore; }
}
