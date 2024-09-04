package it.uniroma1.textadv.characters;

import it.uniroma1.textadv.interfacce.Accarezzabile;
import it.uniroma1.textadv.interfacce.Ingannabile;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Parlabile;
import it.uniroma1.textadv.interfacce.Prendibile;

/**
 * La classe modella il personaggio gatto
 *
 */
public class Gatto extends Characters implements Prendibile, Inventabile, Accarezzabile, Ingannabile{

	/**
	 * costruttore della classe
	 * @param name: nome da associare al personaggio
	 * @param parametro
	 */
	public Gatto(String name, String[] parametro) {
		super(name, parametro);
	}
	
	/**
	 * permette di mettere il personaggio nell'inventario
	 */
	@Override
	public void prendi()
	{
		this.inventa();
	}

	/**
	 * stampa il verso del personaggio
	 */
	@Override
	public void emettiVerso()
	{
		System.out.println("MIAO MIAO!");
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
