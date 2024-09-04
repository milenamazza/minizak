package it.uniroma1.textadv.eccezioni.openingException;

/**
 * La classe gestice l'eccezione generata quando si
 * tenta di aprire un @Openable con la combinazione sbagliata
 *
 */
public class WrongNumberException extends OpeningException {

	public static final String errore = "combinazione errata";

	@Override
	public String getMessage() { return errore; }
}
