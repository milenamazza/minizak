package it.uniroma1.textadv.links;

import it.uniroma1.textadv.Gioco;
import it.uniroma1.textadv.Inglese;
import it.uniroma1.textadv.Aperture.Apertura;
import it.uniroma1.textadv.Aperture.Chiuso;
import it.uniroma1.textadv.eccezioni.openingException.OpeningException;
import it.uniroma1.textadv.eccezioni.openingException.WrongNumberException;

/**
 * La classe modella il @Links Sportello
 *
 */
public class Sportello extends Links{

	private final String combinazione = "2512";
	
	/**
	 *  Costruttore della classe
	 * @param name: nome da associare al @Links
	 * @param parametro
	 */
	public Sportello(String name, String[] parametro) {
		super(name, parametro);
		apertura = new Chiuso();
	}
	
	/**
	 * Definisce le modalità di apertura dello Sportello:
	 * lo sposrtello può essere aperto solamente se la combinazione 
	 * nella stringa in input è corretta
	 */
	@Override
	public void apriCon(String comando) throws OpeningException 
	{
		String s = comando.split(" "+Gioco.getLingua().con()+" ")[1].strip();
		if(s.equals(combinazione))
			setOpen();
		else
			throw new WrongNumberException();
	}
	
	/**
	 * L'Override impedisce al builder del mondo di modificare 
	 * l'apertura definita nel costruttore
	 */
	@Override
	public void setApertura(Apertura apertura) {}

}
