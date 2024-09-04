package it.uniroma1.textadv.factories;

import java.lang.reflect.InvocationTargetException;
import it.uniroma1.textadv.Elementi;
import it.uniroma1.textadv.eccezioni.creazione.ClasseNonTrovataException;
import it.uniroma1.textadv.eccezioni.creazione.CreationalException;

/**
 * classe che gestisce la creazione degli elementi del gioco tramite la reflection
 *
 */
public abstract class Factory {
	
	/**
	 * permette di ottenere un elemento richaiamndo lo specifico costruttore
	 * @param <T> crea e restituisce un elemento di tipo T
	 * @param nome: Stringa con il nome dell'elemento da creare 
	 * @param classe: Classe dell'elemento da creare
	 * @param parametro: Array di Stringhe da associare all'elemento
	 * @param tipo: speciafica a quale tipo dell'enumerazione appartiene l'elemento
	 * @return restituisce un elemento di tipo T
	 * @throws CreationalException: errore nella creazione dell'elemento
	 * @throws ClassNotFoundException: La casse dell'oggetto che deve essere creato è inesistenete
	 */
	public <T> T get(String nome,String classe,String[] parametro, Elementi tipo) throws CreationalException
	{
		try {
			Class<?> classObj =  Class.forName("it.uniroma1.textadv."+tipo.toString().toLowerCase()+"."+classe);
			T instance = (T) classObj.getConstructor(String.class, String[].class).newInstance(nome,parametro);
			return instance;
		} catch (ClassNotFoundException e) {
			throw new ClasseNonTrovataException();
		} catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
			throw new CreationalException();
		}
	};
	
	/**
	 * 
	 * @param <T>
	 * @param nome: Stringa con il nome dell'elemento da creare 
	 * @param classe: Classe dell'elemento da creare
	 * @param parametro: Array di Stringhe da associare all'elemento
	 * @return restituisce un elemento di tipo T
	 * @throws CreationalException: errore nella creazione dell'elemento
	 */
	public abstract <T> T get(String nome,String classe,String[] parametro) throws CreationalException;
}
