package it.uniroma1.textadv.tris;

/**
 * La classe gestisce le eccezioni dovute ad un errato inserimento 
 * dell'indice di riga o colonna
 *
 */
public class OutOfRangeException extends Exception {

	private static final String message = "Riga e colonna devono essere tra 0 e 2";
	
	@Override
	public String getMessage() { return message; }
}
