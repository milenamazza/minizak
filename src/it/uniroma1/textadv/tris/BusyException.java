package it.uniroma1.textadv.tris;

/**
 * La classe gestisce le eccezioni generate dal tentativo di 
 * mettere il proprio simbolo in una posizione non valida
 *
 */
public class BusyException extends Exception {

	private static final String message = "Posizione Occupata";
	
	@Override
	public String getMessage() { return message; }
}
