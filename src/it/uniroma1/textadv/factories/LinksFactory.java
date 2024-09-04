package it.uniroma1.textadv.factories;

import it.uniroma1.textadv.Elementi;
import it.uniroma1.textadv.eccezioni.creazione.CreationalException;
import it.uniroma1.textadv.links.Links;

/**
 * gestisce la creazione dei collegamenti
 *
 */
public class LinksFactory extends Factory {
	
	/**
	 * metodo che restituisce lo specifico link
	 * @throws CreationalException: Eccezione durante la creazione dei @Links
	 */
	public Links get(String nome,String classe,String[] parametro) throws CreationalException
	{
		return super.get(nome, classe, parametro, Elementi.LINKS);
	}

}
