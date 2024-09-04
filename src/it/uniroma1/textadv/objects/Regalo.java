package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.eccezioni.notTakeableException.NotPayedException;
import it.uniroma1.textadv.interfacce.Ingannabile;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Pagabile;
import it.uniroma1.textadv.interfacce.Prendibile;

/**
 * Classe per modellare l'oggetto regalo
 *
 */
public class Regalo extends Objects implements Pagabile,Prendibile,Inventabile,Ingannabile{

	private boolean pagato;
	
	/**
	 * Costruttore della classe regalo
	 * @param name: nome da associare all'oggetto
	 * @param parametro
	 */
	public Regalo(String name, String[] parametro) {
		super(name, parametro);
	}
	
	/**
	 * permette di mettere il regalo nell'inventario, se è stato pagato
	 */
	@Override
	public void prendi() throws NotPayedException
	{	
		if(isPagato())
			this.inventa();
		else
			throw new NotPayedException(this);
	}

	/**
	 * getter del campo: pagato
	 */
	public boolean isPagato() {
		return pagato;
	}
	
	/**
	 * setter del campo: pagato
	 * @param pagato
	 */
	public void setPagato(boolean pagato) {
		this.pagato = pagato;
	}

	/**
	 * permette di pagare l'oggetto
	 */
	@Override
	public void setPagato() {
		pagato = true;
	}

}
