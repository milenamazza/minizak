package it.uniroma1.textadv.eccezioni;

/**
 * La classe gestice l'eccezione generata quando un elemento all'interno del
 * comando non viene trovato o riconosciuto
 *
 */
public class NotFoundException extends Exception {
	
	private String errore = "Elemento Non Presente";
	
	@Override
	public String getMessage()
	{
		return errore;
	}

}
