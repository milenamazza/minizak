package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.eccezioni.notCompatibleException.NonSvitabileException;
import it.uniroma1.textadv.eccezioni.notCompatibleException.NotCompatibleException;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Prendibile;
import it.uniroma1.textadv.interfacce.Svitabile;
import it.uniroma1.textadv.interfacce.Usabile;

/**
 * Modella l'oggetto cacciavite
 *
 */
public class Cacciavite extends Objects implements Prendibile, Inventabile, Usabile {

	/**
	 * costruttore dell'oggetto
	 * @param nome: nome da associare all'oggetto
	 * @param parametro
	 */
	public Cacciavite(String nome, String[] parametro) {
		super(nome, parametro);
	}
	
	/**
	 * permette di trasferire l'oggetto nell'inventario del giocatore
	 */
	@Override
	public void prendi() { this.inventa(); }

	/**
	 * permette di usare il cacciavite su oggetti che implentano l'interfaccia @Svitabile
	 */
	@Override
	public void usa(Objects o) throws NotCompatibleException{
		if (o instanceof Svitabile)
			((Svitabile) o).svita();
		else
			throw new NonSvitabileException(o);
		
	}
}
