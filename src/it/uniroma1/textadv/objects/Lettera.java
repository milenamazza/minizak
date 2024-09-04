package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.Mondo;
import it.uniroma1.textadv.eccezioni.notTakeableException.protectedByException;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Prendibile;
import it.uniroma1.textadv.interfacce.Protetto;

/**
 * modella l'oggetto lettera 
 *
 */
public class Lettera extends Objects implements Inventabile, Prendibile{
	
	/**
	 * costruttore della classe
	 * @param name: nome da associare all'oggetto
	 * @param parametro
	 */
	public Lettera(String name, String[] parametro) {
		super(name, parametro);
	}

	/**
	 * permette di prendere l'oggetto
	 */
	@Override
	public void prendi()
	{	
		this.inventa();
		Mondo.mondo.setVittoria(true);
	}
}
