package it.uniroma1.textadv.characters;

import it.uniroma1.textadv.tris.Tris;

public class Bambino extends Characters{

	/**
	 * Costruttore della classe 
	 * @param name: nome del bambino
	 * @param parametro
	 */
	public Bambino(String name, String[] parametro) {
		super(name, parametro);
	}
	
	/**
	 * quando si tenta di parlare con il bambino,
	 * egli costringerà il giocatore a giocare a tris con lui
	 */
	@Override
	public void parla()
	{
		super.parla();
		System.out.println("ADESSO GIOCHIAMO A TRIS!");
		Tris.gioca();
	}
}
