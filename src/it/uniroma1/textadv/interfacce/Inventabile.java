package it.uniroma1.textadv.interfacce;

import it.uniroma1.textadv.Mondo;
import it.uniroma1.textadv.Player;
import it.uniroma1.textadv.characters.Characters;

/**
 * Interfaccia implementata dagli elementi che possono essere
 * messi nell'inventario del giocatore
 *
 */
public interface Inventabile 
{
	/**
	 * Il metodo aggiunge l'elemento nell'inventario del giocatore 
	 * e ne rimuove il riferimento dalla camera
	 */
	default void inventa()
	{
		Player.getIstance().addOggetto(this);
		Mondo.mondo.getRoom().elimina(this);
	}

	/**
	 * L'elemento viene spostato dall'inventario del giocatore
	 * a quello di un altro personaggio
	 * @param c: persona a cui bisogna cedere l'elemento
	 */
	default void dai(Characters c)
	{
		c.addObject(this);
		Player.getIstance().getInventario().remove(this);
	}
}
