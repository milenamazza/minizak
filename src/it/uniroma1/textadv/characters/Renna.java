package it.uniroma1.textadv.characters;

import it.uniroma1.textadv.interfacce.Accarezzabile;

/**
 * Modella il personaggio renna
 *
 */
public class Renna extends Characters implements Accarezzabile{
	
	/**
	 * Costruttore della classe
	 * @param name: Nome del personaggio
	 * @param parametro
	 */
	public Renna(String name, String[] parametro) {
		super(name, parametro);
	}
	
	/**
	 * stampa il verso del personaggio
	 */
	@Override
	public void emettiVerso()
	{
		System.out.println("BUON ANNO!");
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
