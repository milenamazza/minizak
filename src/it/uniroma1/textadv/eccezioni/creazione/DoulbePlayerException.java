package it.uniroma1.textadv.eccezioni.creazione;


/**
 * Gestisce l'eccezione che si genera quando si prova 
 * a creare 2 @Player
 *
 */
public class DoulbePlayerException extends CreationalException {

	private static final String errore = "Due Player richiesti";
	
	@Override
	public String getMessage()
	{
		return errore;
	}
}
