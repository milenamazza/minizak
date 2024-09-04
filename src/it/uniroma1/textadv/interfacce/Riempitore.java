package it.uniroma1.textadv.interfacce;

/**
 * Implementata dagli oggetti che possono riempire i @Riempibili
 *
 */
public interface Riempitore {
	/**
	 * Riempie un'elemento che implementa l'interfaccia riempibile
	 * @param r: un @Riempibile che deve essere riempito
	 */
	void riempi(Riempibile r);
}
