package it.uniroma1.textadv.Aperture;

import it.uniroma1.textadv.Gioco;
import it.uniroma1.textadv.Player;
import it.uniroma1.textadv.eccezioni.openingException.AlreadyOpenException;
import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.eccezioni.openingException.WrongKeyException;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Openable;
import it.uniroma1.textadv.interfacce.OpenableWith;
import it.uniroma1.textadv.objects.Objects;

/**
 * Implementa le serrature che necessitano di una chiave per essere aperte
 *
 */
public class Chiuso implements Apertura {

	/**
	 * Il metodo blocca l'accesso se si tenta di aprire l' @Openable senza la chiave, 
	 * se questo invece era già aperto, solleva un'eccezione
	 */
	@Override
	public void open(Openable o) throws LockedException, AlreadyOpenException{
		if (!o.isOpen())
			throw new LockedException();
		else
			throw new AlreadyOpenException();
	}
	
	/**
	 * Il metodo determina se la chiave con cui si tenta di aprire l' @Openable sia corretta, 
	 * in caso affermativo l'elemento viene aperto
	 */
	@Override
	public void openWith(String comando, Objects ob, Openable o) throws WrongKeyException
	{
		String s = comando.substring(comando.indexOf(" "+Gioco.getLingua().con()+" "));
		Inventabile i = Player.getIstance().fromInventario(s);
		
		if(i instanceof Objects)
		{
			if(((Objects) i).getName().equals(ob.getName()))
				o.setOpen();
			else
				throw new WrongKeyException(ob.getName());
		}
		else
		{
			throw new WrongKeyException(ob.getName());
		}
	}

}
