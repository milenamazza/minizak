package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.Mondo;
import it.uniroma1.textadv.Player;
import it.uniroma1.textadv.Aperture.Apertura;
import it.uniroma1.textadv.Aperture.Chiuso;
import it.uniroma1.textadv.eccezioni.openingException.AlreadyOpenException;
import it.uniroma1.textadv.eccezioni.openingException.KeyNotNeededException;
import it.uniroma1.textadv.eccezioni.openingException.OpeningException;
import it.uniroma1.textadv.eccezioni.openingException.WrongKeyException;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Openable;
import it.uniroma1.textadv.interfacce.OpenableWith;
import it.uniroma1.textadv.interfacce.Tagliabile;

/**
 * Classe per modellare l'oggetto Armadio
 *
 */
public class Armadio extends Objects implements Openable,OpenableWith, Tagliabile{

	private boolean open;
	//private AperturaCon aperturaCon = new AperturaConOggetto();
	private Apertura apertura = new Chiuso();
	
	/**
	 * costruttore dell'oggetto
	 * @param nome: nome da associare all'oggetto
	 * @param parametro
	 */
	public Armadio(String nome, String[] parametro) {
		super(nome, parametro);
	}
	
	/**
	 * metodo che permette di provare ad aprire l'oggetto
	 */
	@Override
	public void apri() throws OpeningException {
		apertura.open(this);
	}

	/**
	 * metodo che permette di provare ad aprire l'oggetto con un altro oggetto
	 */
	@Override
	public void apriCon(String s) throws OpeningException  {
		if(!isOpen())
		{
			Inventabile i = Player.getIstance().fromInventario(s);
			if(i instanceof Objects && ((Objects)i).getOggetto().getName().equals(getName()))
			{
				setOpen();
				if(isOpen())
					lasciaOggetto();
			}
			else
				throw new WrongKeyException(i.toString());
		}
		else
			throw new AlreadyOpenException();
	}
	
	/**
	 * il metodo controlla se l'oggetto è aperto
	 */
	@Override
	public boolean isOpen() {
		return open;
	}
	
	/**
	 * metodo setter di open
	 * @param open: valore booleano da associare ad open
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}

	/**
	 * il metodo imposta a true la variabile di apertura
	 */
	@Override
	public void setOpen() {
		setOpen(true);
	}

	/**
	 * il seguente metodo permette di aprire forzatamente l'oggetto
	 */
	@Override
	public void taglia() {
		if(!isOpen())
		{
			lasciaOggetto();
		}
		setOpen();
	}
	
	/**
	 * metodo privato che rilascia nella camera gli oggetti, una volta che oggetto viene aperto
	 */
	private void lasciaOggetto()
	{
		Mondo.mondo.getRoom().addObject(oggetto);
		changeObject(null);
	}

}
