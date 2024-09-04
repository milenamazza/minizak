package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.Mondo;
import it.uniroma1.textadv.interfacce.Spegnibile;

/**
 * Modella l'oggetto Camino
 * @author milli
 *
 */
public class Camino extends Objects implements Spegnibile{

	private boolean spento;
	
	/**
	 *  Costruttore della classe camino
	 * @param nome
	 * @param parametro
	 */
	public Camino(String nome, String[] parametro) {
		super(nome, parametro);
	}
	
	/**
	 *permette di spegnere il camino
	 */
	@Override
	public void spegni() {
		if (!isSpento())
		{
			Mondo.mondo.getRoom().addObject(getOggetto());
			changeObject(null);
		}
		setSpento(true);
		
	}

	/**
	 * getter del campo: spento
	 */
	public boolean isSpento() {
		return spento;
	}
	
	/**
	 * setter del campo: spento
	 */
	public void setSpento(boolean spento) {
		this.spento = spento;
	}

}
