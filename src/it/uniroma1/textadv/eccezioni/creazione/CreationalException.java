package it.uniroma1.textadv.eccezioni.creazione;

/**
 * Gestisce le eccezioni sulla creazione del mondo
 *
 */
public class CreationalException extends Exception {
	private static final String errore = "Errore durante la creazione del Mondo";
	
	@Override
	public String getMessage()
	{
		return errore;
	}

}
