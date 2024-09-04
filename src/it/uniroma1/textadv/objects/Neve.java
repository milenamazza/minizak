package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.eccezioni.notCompatibleException.NotCompatibleException;
import it.uniroma1.textadv.eccezioni.notTakeableException.NotTakeableException;
import it.uniroma1.textadv.eccezioni.notTakeableException.protectedByException;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Prendibile;
import it.uniroma1.textadv.interfacce.Protetto;
import it.uniroma1.textadv.interfacce.Spegnibile;
import it.uniroma1.textadv.interfacce.Usabile;
/**
 * 
 *	Classe che modella l'oggetto Neve
 *
 */
public class Neve extends Objects implements Usabile, Protetto, Inventabile,Prendibile {

	private boolean protetto = true;
	
	/**
	 * Costruttore della classe
	 * @param name: Nome da ssociare all'oggetto
	 * @param parametro
	 */
	public Neve(String name, String[] parametro) {
		super(name, parametro);
	}
	
	/**
	 * Utilizza l'ogegtto per spegnere gli oggetti che implementano @Spegnibile
	 */
	@Override
	public void usa(Objects o) throws NotCompatibleException 
	{
		 if (o instanceof Spegnibile)
			 ((Spegnibile)o).spegni();
		 else
				throw new NotCompatibleException();
	}
	
	/**
	 * permette di mettere l'oggetto nell'inventario, se esso non è protetto
	 */
	@Override
	public void prendi() throws NotTakeableException
	{	
		if(!protetto)
			this.inventa();
		else
			throw new protectedByException(this);
	}
	
	/**
	 * 
	 * getter del campo: protetto
	 */
	public boolean isProtetto() {
		return protetto;
	}
	
	/**
	 * setter del campo: protetto
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

}
