package it.uniroma1.textadv.eccezioni.openingException;


/**
 * La classe gestice l'eccezione generata quando si tenta
 * di aprire un elemento con la chiaev errata
 *
 */
public class WrongKeyException extends OpeningException {

	private String chiave;
	private String errore = "Chiave Sbagliata: utilizzare ";
	
	/**
	 * Costruttore dell'eccezioen
	 * @param chiave: chiave da utilizzare per aprire l' @Openable
	 */
	public WrongKeyException(String chiave) {
		this.chiave = chiave;
		errore = errore+chiave;
	}

	@Override
	public String getMessage() { return errore; }
}
