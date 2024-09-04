package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.eccezioni.notCompatibleException.EmptyObjectException;
import it.uniroma1.textadv.eccezioni.notCompatibleException.NotCompatibleException;
import it.uniroma1.textadv.eccezioni.notTakeableException.NotPayedException;
import it.uniroma1.textadv.eccezioni.notTakeableException.NotTakeableException;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Pagabile;
import it.uniroma1.textadv.interfacce.Prendibile;
import it.uniroma1.textadv.interfacce.Riempibile;
import it.uniroma1.textadv.interfacce.Riempitore;
import it.uniroma1.textadv.interfacce.Spegnibile;
import it.uniroma1.textadv.interfacce.Usabile;

/**
 * Classe per modellare l'oggetto secchio
 *
 */
public class Secchio extends Objects implements Prendibile, Inventabile, Usabile, Riempibile, Pagabile {

	private boolean pagato;
	private boolean pieno;
	
	/**
	 * Costruttore dell'oggetto
	 * @param nome: nome dell'oggetto
	 * @param parametro
	 */
	public Secchio(String nome, String[] parametro) {
		super(nome, parametro);
	}
	
	/**
	 * permette di mettere l'oggetto nell'inventario se questo è pagato
	 */
	@Override
	public void prendi() throws NotTakeableException
	{	
		if(pagato)
			this.inventa();
		else
			throw new NotPayedException(this);
	}

	/**
	 * Permette di utilizzare l'oggetto
	 */
	@Override
	public void usa(Objects o) throws NotCompatibleException {
		if (o instanceof Riempitore)
		{
			((Riempitore) o).riempi(this);
		}
		
		else if (o instanceof Spegnibile)
		{
			if (isPieno())
			{
				((Spegnibile)o).spegni();
				setPieno(false);
			}
			else
				throw new EmptyObjectException(this);
		}
		else
			throw new NotCompatibleException();
		
	}
	
	/**
	 * getter di pieno
	 */
	public boolean isPieno() {
		return pieno;
	}
	
	/**
	 * setter di pieno
	 */
	@Override
	public void setPieno(boolean pieno) {
		this.pieno = pieno;
	}

	/**
	 * paga l'oggetto
	 */
	@Override
	public void setPagato() {
		pagato = true;
		
	}

}
