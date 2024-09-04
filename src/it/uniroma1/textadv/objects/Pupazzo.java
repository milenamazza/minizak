package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.Mondo;
import it.uniroma1.textadv.interfacce.Scioglibile;

/**
 * CLasse per modellare l'oggetto Pupazzo Di Neve
 *
 */
public class Pupazzo extends Objects implements Scioglibile{

	private boolean sciolto = false;
	
	/**
	 * costruttore dell'oggetto
	 * @param name: nome dell'oggetto
	 * @param parametro
	 */
	public Pupazzo(String name, String[] parametro) {
		super(name, parametro);
	}
	
	/**
	 * fa sciogliere il pupazzo di neve
	 */
	@Override
	public void sciogli() {
		if (!isSciolto())
		{
			Mondo.mondo.getRoom().addObject(getOggetto());
			changeObject(null);
		}
		setSciolto(true);
	}
		
		/**
		 * getter del campo: sciolto
		 */
		public boolean isSciolto() {
			return sciolto;
		}
		
		/**
		 * setter del campo: sciolto
		 */
		public void setSciolto(boolean sciolto) {
			this.sciolto = sciolto;
		}
}
