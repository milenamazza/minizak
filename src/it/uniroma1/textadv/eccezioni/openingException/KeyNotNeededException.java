package it.uniroma1.textadv.eccezioni.openingException;

/**
 * La classe gestice l'eccezione generata quando si tenta di aprire
 * con una chiave un elemento che non la necessita
 *
 */
public class KeyNotNeededException extends OpeningException  {

	private final String errore = "Non è necessaria alcuna chiave";
	
	@Override
	public String getMessage() { return errore; }
}
