package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.WorldBuilder;
import it.uniroma1.textadv.eccezioni.creazione.AlreadyPositioned;
import it.uniroma1.textadv.eccezioni.notCompatibleException.NotCompatibleException;
import it.uniroma1.textadv.eccezioni.notTakeableException.NotPayedException;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Pagabile;
import it.uniroma1.textadv.interfacce.Prendibile;
import it.uniroma1.textadv.interfacce.Rompibile;
import it.uniroma1.textadv.interfacce.Tagliabile;
import it.uniroma1.textadv.interfacce.Usabile;
import it.uniroma1.textadv.links.Links;

/**
 * 
 * Classe per modellare l'oggetto Tronchesi
 *
 */
public class Tronchesi extends Objects implements Inventabile, Prendibile, Pagabile, Usabile {

	private boolean pagato;
	
	/**
	 * costruttore della classe
	 * @param nome: nome dell'oggetto
	 * @param parametro
	 */
	public Tronchesi(String nome, String[] parametro) {
		super(nome, parametro);
	}
	
	/**
	 * inventa l'oggetto
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
	 * getter delal variabile pagato
	 * @return valore di pagato
	 */
	public boolean isPagato() {
		return pagato;
	}

	/**
	 * setter della variabile pagato
	 * @param pagato: avalore da assegnare a pagato
	 */
	public void setPagato(boolean pagato) {
		this.pagato = pagato;
	}

	/**
	 * paga l'oggetto
	 */
	@Override
	public void setPagato() {
		pagato = true;
	}

	/**
	 *  utilizzo delle tronchesi su un @Objects
	 */
	@Override
	public void usa(Objects o) throws NotCompatibleException {
	
		if(o instanceof Tagliabile)
		{
			((Tagliabile) o).taglia();
		}
		else
			throw new NotCompatibleException();
		
	}
	
	@Override
	public void setOggetto( WorldBuilder wb)
	{
		String o = wb.parametri.get(this);
		if ( o != null)
			oggetto = wb.objects.get(o);

	}

}
