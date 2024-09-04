package it.uniroma1.textadv.eccezioni.notTakeableException;

/**
 * La classe gestice l'eccezione generata quando si
 * tenta di prendere un oggetto che non implementa l'interfaccia @Prendibile
 * oppure che implenta @Protetto
 *
 */
public class NotTakeableException extends Exception {
	
private final String errore = "Non è possibile prendere l'oggetto";
	
	@Override
	public String getMessage() { return errore; }
}
