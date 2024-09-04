package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.Mondo;
import it.uniroma1.textadv.eccezioni.notCompatibleException.AlreadyBrokenException;
import it.uniroma1.textadv.interfacce.Rompibile;

/**
 * 
 * Classe per modellare l'oggetto Salvadanaio
 *
 */
public class Salvadanaio extends Objects implements Rompibile {

	private boolean rotto;
	
	/**
	 * getter del campo: rotto
	 * @return
	 */
	public boolean isRotto() {
		return rotto;
	}

	/**
	 * setter del campo: rotto
	 * @param rotto
	 */
	public void setRotto(boolean rotto) {
		this.rotto = rotto;
	}

	/**
	 * costruttore della classe
	 * @param nome: nome da associare all'oggetto
	 * @param parametro
	 */
	public Salvadanaio(String nome, String[] parametro) {
		super(nome, parametro);
	}

	/**
	 * permette di rompere il salvadanaio
	 */
	@Override
	public void rompi() throws AlreadyBrokenException {
		if(!isRotto())
		{
			Mondo.mondo.getRoom().addObject(getOggetto());
			changeObject(null);
			setRotto(true);
			
		}
		else
			throw new AlreadyBrokenException(this);
		
	}

}
