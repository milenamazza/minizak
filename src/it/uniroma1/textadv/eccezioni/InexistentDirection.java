package it.uniroma1.textadv.eccezioni;

/**
 * La classe gestice l'eccezione generata quando il giocatore
 * prova a muoversi in una direzioen insesistente
 *
 */
public class InexistentDirection extends Exception {
	private final String errore = "Direzione Inesistente";
	
	@Override
	public String getMessage() { return errore; }
	

}
