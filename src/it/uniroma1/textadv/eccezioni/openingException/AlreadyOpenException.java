package it.uniroma1.textadv.eccezioni.openingException;

/**
 *  La classe gestice l'eccezione generata quando si tenta di aprire un
 *  elemento già aperto
 *
 */
public class AlreadyOpenException extends OpeningException {
	
	private final String errore = "L'oggetto è già aperto";
	
	@Override
	public String getMessage() { return errore; }
}
