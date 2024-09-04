package it.uniroma1.textadv.factories;

import java.lang.reflect.InvocationTargetException;

import it.uniroma1.textadv.Elementi;
import it.uniroma1.textadv.characters.Characters;
import it.uniroma1.textadv.eccezioni.creazione.CreationalException;

/**
 * gestisce la creazione dei personaggi
 *
 */
public class CharactersFactory extends Factory {
	
	/**
	 * metodo che restituisce il personaggio specifico
	 * @throws CreationalException: Eccezione durante la creazione dei @Characters
	 */
	public Characters get(String nome,String classe,String[] parametro) throws CreationalException
	{
		return super.get(nome, classe, parametro, Elementi.CHARACTERS);
	}
}
