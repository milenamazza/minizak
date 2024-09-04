package it.uniroma1.textadv.eccezioni.openingException;

/**
 * La classe gestice l'eccezione generata quando si
 * teta di accedere ad un elemento chiuso
 *
 */
public class LockedException extends OpeningException  {	

	private final String errore = "L'oggetto è bloccato";
	
	@Override
	public String getMessage() { return errore; }
}
