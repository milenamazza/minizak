package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.interfacce.Svitabile;
import it.uniroma1.textadv.links.Links;

/**
 * Classe per mondellare l'oggetto Vite
 * 
 */
public class Vite extends Objects implements Svitabile{
	
	private boolean avvitata = true;
	
	/**
	 * getter del parametro privato avvitata
	 * @return il valore booleano di avvitata
	 */
	public boolean isAvvitata() {
		return avvitata;
	}

	/**
	 * setter del parametro avvitata
	 * @param avvitata: valore booleano
	 */
	public void setAvvitata(boolean avvitata) {
		this.avvitata = avvitata;
	}

	/**
	 * costruttore della classe
	 * @param nome: nome
	 * @param parametro: parametri
	 */
	public Vite(String nome, String[] parametro) {
		super(nome, parametro);
	}

	/**
	 * svita la vite
	 */
	@Override
	public void svita() {
		setAvvitata(false);
		
	}
	
	
}
