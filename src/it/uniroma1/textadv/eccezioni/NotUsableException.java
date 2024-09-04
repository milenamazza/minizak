package it.uniroma1.textadv.eccezioni;

/**
 * La classe gestice l'eccezione generata quando si tenta di
 * usare un elemento che non implementa l'interfaccia @Usabile
 *
 */
public class NotUsableException extends Exception {

	private final String errore = "Non è possibile usare l'oggetto";
	
	@Override
	public String getMessage() { return errore; }
}
