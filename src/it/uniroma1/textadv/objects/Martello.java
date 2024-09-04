package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.eccezioni.notCompatibleException.NotCompatibleException;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Prendibile;
import it.uniroma1.textadv.interfacce.Rompibile;
import it.uniroma1.textadv.interfacce.Usabile;
/**
 * 
 * Classe per modellare l'oggetto martello
 *
 */
public class Martello extends Objects implements Prendibile, Inventabile, Usabile{

	/**
	 * Costruttore della classe
	 * @param nome: nome da associare all'oggetto
	 * @param parametro
	 */
	public Martello(String nome, String[] parametro) {
		super(nome, parametro);
	}
	
	/**
	 * permette di mettere il martello nell'inventario
	 */
	@Override
	public void prendi() { this.inventa(); }

	/**
	 * permette di utilizzare il martello e romper gli oggetti che implementano @Rompibile
	 */
	@Override
	public void usa(Objects o) throws NotCompatibleException {
	
		if(o instanceof Rompibile)
		{
			((Rompibile) o).rompi();
		}
		else
			throw new NotCompatibleException();
		
		
	}

}
