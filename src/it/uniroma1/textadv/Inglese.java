package it.uniroma1.textadv;

import it.uniroma1.textadv.eccezioni.InexistentDirection;
import it.uniroma1.textadv.eccezioni.NotAllowedDirectionExeption;
import it.uniroma1.textadv.eccezioni.NotFoundException;
import it.uniroma1.textadv.eccezioni.NotLegalCommandException;
import it.uniroma1.textadv.eccezioni.NotUsableException;
import it.uniroma1.textadv.eccezioni.notCompatibleException.NotCompatibleException;
import it.uniroma1.textadv.eccezioni.notTakeableException.NotTakeableException;
import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.eccezioni.openingException.NotOpenableException;
import it.uniroma1.textadv.eccezioni.openingException.OpeningException;

/**
 * Classe utilizzata per mappare i comandi da inglese ad italiano
 *
 */
public class Inglese {
	
	public static String[] da = new String[] {"da","from"};
	public static String[] con = new String[] {"con","with"};
	public static String[] a = new String[] {"a","to"};
	public static String[] su = new String[] {"su","on"};

	/**
	 * mappa il comando "look()" a "guarda()"
	 */
	public static void look()
	{
		Player.getIstance().guarda();
	}
	
	/**
	 * mappa il comando "look(String comando)" in "guarda(String comando)"
	 * @param comando
	 * @throws NotFoundException
	 */
	public static void look(String comando) throws NotFoundException
	{
		Player.getIstance().guarda(comando);
	}
	
	/**
	 * mappa il comando "open(String comando)" in "apri(String comando)"
	 * @param comando
	 * @throws NotFoundException
	 * @throws NotOpenableException
	 * @throws OpeningException
	 */
	public static void open(String comando) throws NotFoundException, NotOpenableException, OpeningException
	{
		Player.getIstance().apri(comando);
	}
	
	/**
	 * Mappa il comando "go(String comando)" in "vai(String comando)"
	 * @param comando
	 * @throws LockedException
	 * @throws NotAllowedDirectionExeption
	 * @throws InexistentDirection
	 */
	public static void go(String comando) throws LockedException, NotAllowedDirectionExeption, InexistentDirection 
	{
		Player.getIstance().vai(comando);
	}
	
	/**
	 * mappa il comando "take(String comando)" in "prendi("String comando")
	 * @param comando
	 * @throws LockedException
	 * @throws NotFoundException
	 * @throws NotTakeableException
	 */
	public static void take(String comando) throws LockedException, NotFoundException, NotTakeableException 
	{
		Player.getIstance().prendi(comando);
	}
	
	/**
	 * mappa il comando "cuddle(String comando)" in "accarezza(String comando)"
	 * @param comando
	 * @throws NotFoundException
	 */
	public static void cuddle(String comando) throws NotFoundException
	{
		Player.getIstance().accarezza(comando);
	}
	
	/**
	 * mappa il comando "inventory()" ad "inventario()"
	 */
	public static void inventory() 
	{
		Player.getIstance().inventario();
	}
	
	/**
	 * mappa il comando "use(String comando)" in "usa(String comando)"
	 * @param comando
	 * @throws LockedException
	 * @throws NotFoundException
	 * @throws NotUsableException
	 * @throws NotCompatibleException
	 */
	public static void use(String comando) throws LockedException, NotFoundException, NotUsableException, NotCompatibleException
	{
		Player.getIstance().usa(comando);
	}
	
	/**
	 * mappa il comando "give(String comando)" in "dai(String comando)"
	 * @param comando
	 * @throws LockedException
	 * @throws NotFoundException
	 * @throws NotUsableException
	 * @throws NotCompatibleException
	 */
	public static void give(String comando) throws LockedException, NotFoundException, NotUsableException, NotCompatibleException
	{
		Player.getIstance().usa(comando);
	}
	
	/**
	 * mappa il comando "enter(String comando)" in "entra(String comando)"
	 * @param comando
	 * @throws LockedException
	 * @throws NotFoundException
	 */
	public static void enter(String comando) throws LockedException, NotFoundException
	{
		Player.getIstance().entra(comando);
	}
	
	/**
	 * mappa il comando "smash(String comando)" in "rompi(String comando)"
	 * @param comando
	 * @throws NotCompatibleException
	 * @throws NotFoundException
	 * @throws NotLegalCommandException
	 */
	public static void smash(String comando) throws NotCompatibleException, NotFoundException, NotLegalCommandException
	{
		Player.getIstance().rompi(comando);
	}
	
	/**
	 * mappa il comando "talk(String comando)" in "parla(String comando)"
	 * @param comando
	 * @throws NotFoundException
	 */
	public static void talk(String comando) throws NotFoundException
	{
		Player.getIstance().parla(comando);
	}
	
	
}
