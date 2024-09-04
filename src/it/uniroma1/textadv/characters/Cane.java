package it.uniroma1.textadv.characters;

import it.uniroma1.textadv.interfacce.Accarezzabile;
import it.uniroma1.textadv.interfacce.Parlabile;

/**
 * La classe modella il personaggio cane
 *
 */
public class Cane extends Characters implements Accarezzabile{

	/**
	 * Costruttore della classe
	 * @param name: nome del personaggio
	 * @param parametro
	 */
	public Cane(String name, String[] parametro) {
		super(name, parametro);
	}
	
	/**
	 * stampa il verso del personaggio
	 */
	@Override
	public void emettiVerso()
	{
		System.out.println("BAU BAU!");
	}
	
	/**
	 * mappa il metodo parla() a emettiVerso()
	 */
	@Override
	public void parla()
	{
		emettiVerso();
	}

}
