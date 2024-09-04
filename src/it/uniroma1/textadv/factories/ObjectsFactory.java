package it.uniroma1.textadv.factories;

import it.uniroma1.textadv.Elementi;
import it.uniroma1.textadv.eccezioni.creazione.CreationalException;
import it.uniroma1.textadv.objects.Objects;

/**
 * classe che gestisce la creazione degli oggetti
 * @author milli
 *
 */
public class ObjectsFactory extends Factory{
	
	/**
	 * metodo che restituisce l'oggetto specifico
	 * @throws CreationalException: Eccezione durante la creazione degli @Objects
	 */
	public Objects get(String nome,String classe,String[] parametro) throws CreationalException
	{
		return super.get(nome, classe, parametro,Elementi.OBJECTS);
	}
	
}

	