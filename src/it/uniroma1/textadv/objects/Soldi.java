package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Prendibile;

/**
 * Classe per modellare l'oggetto soldi
 *
 */
public class Soldi extends Objects implements Prendibile, Inventabile {

	/**
	 * costruttore della classe
	 * @param nome: nome dell'oggetto
	 * @param parametro
	 */
	public Soldi(String nome, String[] parametro) {
		super(nome, parametro);
	}
	
	/**
	 * permette di mettere l'oggetto nell'inventario
	 */
	@Override
	public void prendi()
	{
		this.inventa();
	}
}
