package it.uniroma1.textadv.eccezioni;

/**
 * La classe gestice l'eccezione generata quando il giocatore prova
 * a muoversi in una direzione non lecita
 *
 */
public class NotAllowedDirectionExeption extends Exception {

	private final String errore = "Non è possibile procedere in questa direzione";
	
	@Override
	public String getMessage() { return errore; }
}
