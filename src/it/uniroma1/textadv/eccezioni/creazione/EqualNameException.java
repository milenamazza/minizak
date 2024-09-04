package it.uniroma1.textadv.eccezioni.creazione;

/**
 * La classe gestice l'eccezione generata quando si assegna il medesimo
 * nome a due oggetti della stessa classe
 *
 */
public class EqualNameException extends CreationalException {

	private static final String errore = "Elementi con lo stesso nome";
	
	@Override
	public String getMessage()
	{
		return errore;
	}
}
