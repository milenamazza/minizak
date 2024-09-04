package it.uniroma1.textadv.Aperture;

import it.uniroma1.textadv.eccezioni.openingException.KeyNotNeededException;
import it.uniroma1.textadv.interfacce.Openable;
import it.uniroma1.textadv.interfacce.OpenableWith;
import it.uniroma1.textadv.objects.Objects;

/**
 * Modella l'apertura che non necessita 
 *
 */
public class AperturaSemplice implements Apertura {

	/**
	 * L'oggetto si apre
	 */
	public void open(Openable o) { o.setOpen(); }
	
	/**
	 * Il metodo viene richiamato quando si tenta di aprire con 
	 * una chiave un elemento che non la encessita
	 */
	@Override
	public void openWith(String comando, Objects ob, Openable o) throws KeyNotNeededException {
		throw new KeyNotNeededException();
}

}