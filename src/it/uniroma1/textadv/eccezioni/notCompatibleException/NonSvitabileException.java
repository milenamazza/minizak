package it.uniroma1.textadv.eccezioni.notCompatibleException;

import it.uniroma1.textadv.objects.Objects;

/**
 * La classe gestice l'eccezione generata quando si tenta
 * di svitare un elemento che non implementa @Svitabile
 *
 */
public class NonSvitabileException extends NotCompatibleException {
	
	private final static String errore = "Non è possibile svitare ";
	private Object o;
	
	/**
	 * Costruttore della classe
	 * @param o: elemento che non può essere svitato
	 */
	public NonSvitabileException(Object o) {
		this.o = o;
	}
	
	@Override
	public String getMessage()
	{
		return errore + o.toString();
	}

}
