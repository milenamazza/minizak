package it.uniroma1.textadv.eccezioni.creazione;

/**
 * La classe gestice l'eccezione generata quando si 
 * tenta di piazzare un elemento più di una volta all'interno del mondo
 *
 */
public class AlreadyPositioned extends CreationalException {

	private static final String errore = "Oggetto duplicato";
	
	@Override
	public String getMessage()
	{
		return errore;
	}
}
