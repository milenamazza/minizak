package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.Mondo;
import it.uniroma1.textadv.eccezioni.notTakeableException.protectedByException;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Prendibile;
import it.uniroma1.textadv.interfacce.Protetto;

/**
 * 
 * Classe per modellare l'oggetto Tesoro
 *
 */
public class Tesoro extends Objects implements Protetto, Inventabile, Prendibile{
	
	private boolean protetto;
	
	public Tesoro(String nome, String[] parametro) {
		super(nome, parametro);
		protetto = true;
	}
	
	/**
	 * getter di protetto
	 */
	public boolean isProtetto() {
		return protetto;
	}
	
	/**
	 * setter di protetto
	 */
	private void setProtetto(boolean protetto) {
		this.protetto = protetto;
	}
	
	/**
	 * rende l'oggetto prendibile
	 */
	@Override
	public void setPrendibile() {
		setProtetto(false);
	}

	/**
	 * l'oggetto viene preso, se non è protetto
	 */
	@Override
	public void prendi() throws protectedByException
	{	
		if(!isProtetto())
		{
			this.inventa();
			Mondo.mondo.setVittoria(true);
		}
		else
			throw new protectedByException(this);
	}
}
