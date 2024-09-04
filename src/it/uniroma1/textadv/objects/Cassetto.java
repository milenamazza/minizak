package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.Aperture.Apertura;
import it.uniroma1.textadv.Aperture.AperturaSemplice;
import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.eccezioni.openingException.OpeningException;
import it.uniroma1.textadv.interfacce.Openable;

/**
 * L'oggetto permette di modellare l'oggetto Cassetto
 *
 */
public class Cassetto extends Objects implements Openable {

	private boolean open = false;
	private Apertura apertura = new AperturaSemplice();
	
	/**
	 * costruttore della classe
	 * @param nome: nome da associare all'oggetto
	 * @param parametro
	 */
	public Cassetto(String nome, String[] parametro) {
		super(nome, parametro);
	}
	
		/**
		 * restituisce una descrizione differente quando l'oggetto è aperto o chiuso
		 */
		@Override
		public String getDescription()
		{
			if (!isOpen() || getOggetto() == null )
			{
				return super.getDescription();
			}
			
			else
			{
				return super.getDescription() + "\n" + "Gli oggetti all'interno del cassetto sono: " + oggetto.getName();
			}
		}
		
		/**
		 * apre il cassetto
		 * @throws LockedException: L'oggetto è bloccato
		 */
		@Override
		public void apri() throws OpeningException 
		{
			apertura.open(this);
		}

		/**
		 * imposta la variabile di apertura a true
		 */
		@Override
		public void setOpen() {
			setOpen(true);
		}

		/**
		 * getter del campo: open
		 */
		@Override
		public boolean isOpen() {
			return open;
		}

		/**
		 * setter del campo: open
		 */
		public void setOpen(boolean open) {
			this.open = open;
		}

}
