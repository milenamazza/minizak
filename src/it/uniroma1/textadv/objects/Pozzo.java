package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.interfacce.Riempibile;
import it.uniroma1.textadv.interfacce.Riempitore;

/**
 * Classe per modellare l'oggetto pozzo
 *
 */
public class Pozzo extends Objects implements Riempitore {

	/**
	 * costruttore della classe
	 * @param nome: nome da associare all'oggetto
	 * @param parametro
	 */
	public Pozzo(String nome, String[] parametro) {
		super(nome, parametro);
	}
	
	/**
	 * riempie i @Riempibili con l'acqua del pozzo
	 */
	@Override
	public void riempi(Riempibile r) {
		r.setPieno(true);
	}

}
