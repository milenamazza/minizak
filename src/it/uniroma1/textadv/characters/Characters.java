package it.uniroma1.textadv.characters;

import java.util.ArrayList;

import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Parlabile;

/**
 * classe che modella i personaggi ausiliari del gioco
 *
 */
public abstract class Characters implements Parlabile{
	private String name;
	private ArrayList<Inventabile> inventario;
	
	/**
	 * costruttore della classe 
	 * @param name: nome del personaggio
	 * @param parametro: eventuali parametri da associare al pesonagggio
	 */
	public Characters(String name, String[] parametro) { this.name = name; inventario = new ArrayList(); }
	
	/**
	 * override del metodo toString della classe Object
	 */
	@Override
	public String toString() { return name; }

	/**
	 * metodo getter del campo inventario
	 * @return inventario del personaggio
	 */
	public ArrayList<Inventabile> getInventario() {
		return inventario;
	}

	/**
	 * aggiunge un @Inventabile all'inventario del personaggio
	 * @param i: @Inventabile da mettere nell'inventario
	 */
	public void addObject(Inventabile i) {
		inventario.add(i);
	}
	
	/**
	 * metodo che consete al personaggio di parlare
	 */
	@Override
	public void parla()
	{
		System.out.println("Ciao, sono "+name);
	}
	
}
