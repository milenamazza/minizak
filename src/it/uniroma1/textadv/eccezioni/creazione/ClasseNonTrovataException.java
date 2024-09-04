package it.uniroma1.textadv.eccezioni.creazione;

/**
 * La classe gestice l'eccezione generata quando si tenta di
 * creare un elemento la cui classe non è riconosciuta
 *
 */
public class ClasseNonTrovataException extends CreationalException {
	
	private static final String errore = "Classe non trovata";
	
	@Override
	public String getMessage()
	{
		return errore;
	}
}
