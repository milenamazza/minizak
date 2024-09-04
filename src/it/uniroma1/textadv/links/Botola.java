package it.uniroma1.textadv.links;

import it.uniroma1.textadv.Aperture.Apertura;
import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.eccezioni.openingException.OpeningException;
import it.uniroma1.textadv.interfacce.Openable;
import it.uniroma1.textadv.interfacce.OpenableWith;
import it.uniroma1.textadv.objects.Objects;
import it.uniroma1.textadv.objects.Vite;

/**
 * La classe modella il @Links che rappresenta la botola
 *
 */
public class Botola extends Links{

	/**
	 * Costruttore della classe
	 * @param name: nome da associare al @Liks
	 * @param parametro
	 */
	public Botola(String name, String[] parametro) {
		super(name, parametro);
		
			apertura = new Apertura() {

			@Override
			public void open(Openable o) throws OpeningException {}

			@Override
			public void openWith(String comando, Objects ob, Openable o) throws OpeningException {}
		};
	
	}
	
	// Fa in modo che il builder non modifichi l'apertura 
	/**
	 * L'override del metodo rende impossibile al builder del mondo
	 * modificare l'apertura definita nel costruttore dell'oggetto
	 */
	@Override
	public void setApertura(Apertura aperturaCon) {} 
	
	/**
	 * Determina le modalità di apertura dell'oggetto: 
	 * se la vite non è avvitata, l'oggetto può essere aperto
	 */
	@Override 
	public void apri() throws LockedException
	{
		Vite j = (Vite) getKey();
		if(!j.isAvvitata())
		{
			setOpen();
		}
		else
			throw new LockedException();
	}

}
