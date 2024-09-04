package it.uniroma1.textadv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import it.uniroma1.textadv.Direzione;
import it.uniroma1.textadv.characters.Characters;
import it.uniroma1.textadv.eccezioni.InexistentDirection;
import it.uniroma1.textadv.eccezioni.NotAllowedDirectionExeption;
import it.uniroma1.textadv.eccezioni.NotFoundException;
import it.uniroma1.textadv.eccezioni.NotLegalCommandException;
import it.uniroma1.textadv.eccezioni.NotUsableException;
import it.uniroma1.textadv.eccezioni.notCompatibleException.NotCompatibleException;
import it.uniroma1.textadv.eccezioni.notTakeableException.NotTakeableException;
import it.uniroma1.textadv.eccezioni.openingException.KeyNotNeededException;
import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.eccezioni.openingException.NotOpenableException;
import it.uniroma1.textadv.eccezioni.openingException.OpeningException;
import it.uniroma1.textadv.interfacce.Accarezzabile;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Openable;
import it.uniroma1.textadv.interfacce.OpenableWith;
import it.uniroma1.textadv.interfacce.Parlabile;
import it.uniroma1.textadv.interfacce.Prendibile;
import it.uniroma1.textadv.interfacce.Rompibile;
import it.uniroma1.textadv.interfacce.Usabile;
import it.uniroma1.textadv.links.Linkable;
import it.uniroma1.textadv.links.Links;
import it.uniroma1.textadv.objects.Objects;

/**
 * classe costruita tramite il pattern del singoletto, adibita alla creazione del giocatore che deve essere unico
 */
public class Player {
	
	private String nome;
	private static Player player;
	private List<Inventabile> inventario;
	
	/**
	 * costruttore privato
	 * @param nome
	 */
	private Player(String nome) 
	{ 
		this.nome = nome;
		setInventario(new ArrayList<>());
	}
	
	/**
	 * metodo statico per ottenere l'unica istanza della classe
	 * @param nome
	 * @return
	 */
	public static Player getIstance(String nome)
	{
		if (player == null)
		{
			player = new Player(nome);
		}
		return player;
	}
	
	/**
	 * restituisce l'istanza del giocatore
	 * @return
	 */
	public static Player getIstance() {return player;}
	
	/**
	 * Descrive la camera
	 */
	public void guarda()
	{	
		System.out.println("############### "+Mondo.mondo.getRoom().getName()+" ###############");
		System.out.println(Mondo.mondo.getRoom().getDescription());
		System.out.println("Personaggi: " + Mondo.mondo.getRoom().getCharactersList());
		System.out.println("Oggetti: " + Mondo.mondo.getRoom().getObjectsList());
		System.out.println("Links: " + Mondo.mondo.getRoom().getLinksList());
		System.out.println("###############################################");
	}
	
	
	/**
	 * Descrive un oggetto presente nella camera
	 * @param comando: stringa contenente il comando in input
	 * @throws NotFoundException: l'oggetto non è presente
	 */
	public void guarda(String comando) throws NotFoundException
	{	
		Objects o = Room.getObject(comando);
		
		if (o != null)
		{
			System.out.println(o.getDescription());
		}
		else
		{
			throw new NotFoundException();
		}
	}
	
	/**
	 * apre un oggetto o linkable nella camera, se questo può essere aperto
	 * @param comando: stringa contenente il comando in input
	 * @throws NotFoundException: l'elemento non è presente
	 * @throws NotOpenableException: l'elemento non può essere aperto
	 * @throws OpeningException: errore sul tentativo di apertura
	 */
	public void apri(String comando) throws NotFoundException, NotOpenableException, OpeningException 
	{
		String[] token = comando.split("\\s+");
		boolean con = Arrays.stream(token).anyMatch(x->x.toLowerCase().equals(Gioco.getLingua().con()));
		
		if (con) 
			apriCon(comando); 
		else
		{
			Linkable l = Room.getLinkable(comando);
			if (l instanceof Openable) { ((Openable) l).apri(); return;}
			
			Objects o = Room.getObject(comando);
			if (o instanceof Openable) { ((Openable) o).apri(); return; }
			
			if (l==null && o==null)
				throw new NotFoundException();
			else
				throw new NotOpenableException();
			
		}

	}
	
	/**
	 * metodo privato che viene richaimato dal metodo apri(String comando) nel caso in cui 
	 * si sta tentando di aprire un oggetto o linkable con un oggetto
	 * @param comando: stringa contenente il comando in input
	 * @throws NotFoundException: l'elemento non è presente
	 * @throws NotOpenableException: l'elemento non può essere aperto
	 * @throws OpeningException: errore sul tentativo di apertura
	 */
	private void apriCon(String comando) throws NotFoundException, NotOpenableException, OpeningException
	{
		Linkable l = Room.getLinkable(comando);
		if (l instanceof OpenableWith) { ((OpenableWith) l).apriCon(comando); return;}
		
		Objects o = Room.getObject(comando);
		if (o instanceof OpenableWith) { ((OpenableWith) o).apriCon(comando); return; }
		
		if (l==null && o==null)
			throw new NotFoundException();
		else
			throw new NotOpenableException();
	}
	
	/**
	 * il metodo permette al giocatore di muoversi nelle direzioni dell'enumerazione Direzione
	 * @param comando: stringa contenente il comando in input
	 * @throws NotAllowedDirectionExeption: Non esiste il collegamento nella direzione richiesta
	 * @throws InexistentDirection: La direzione richiesta non esiste
	 * @throws LockedException: Non si può procedere poiché l'accesso è bloccato
	 */
	public void vai(String comando) throws NotAllowedDirectionExeption, InexistentDirection, LockedException
	{
		List<String> direzione = List.of(comando.strip().toUpperCase().split("\\s+"));
		Direzione d = List.of(Direzione.values()).stream().filter(x->direzione.contains(x.toString())).findAny().orElse(null);
		if (d!=null)
		{
			if(Mondo.mondo.getRoom().getLinksList().containsKey(d.converti()))
			{
				Mondo.mondo.getRoom().getLinksList().get(d.converti()).vai();
			}
			else
			{
				throw new NotAllowedDirectionExeption();
			}
		}
		else
			throw new InexistentDirection();
	}
	
	
	/**
	 * permette al giocatore di raccogliere elementi da mettere nel suo inventario
	 * @param comando: stringa contenente il comando in input
	 * @throws NotFoundException: l'elemento non è presente nella camera
	 * @throws NotTakeableException: l'elemento non può essere preso
	 * @throws LockedException: l'elemento è bloccato
	 */
	public void prendi(String comando) throws NotFoundException, NotTakeableException, LockedException
	{
		String[] token = comando.split("\\s+");
		boolean da = Arrays.stream(token).anyMatch(x->x.toLowerCase().equals(Gioco.getLingua().da()));
		if (da) 
			prendiDa(comando);
		else
		{
			Objects i = Room.getObject(comando);
			if ( i instanceof Prendibile ) {((Prendibile) i).prendi(); return;}
			
			Linkable l = Room.getLinkable(comando);
			if ( l instanceof Prendibile ) {((Prendibile) l).prendi(); return;}
			
			Characters c = Room.getCharacter(comando);
			if ( c instanceof Prendibile ) {((Prendibile) c).prendi(); return;}
			
			if (i==null && l==null && c==null)
				throw new NotFoundException();
			else
				throw new NotTakeableException();
		}
	}
	
	/**
	 * metodo privato che viene richiamato da prendi(String comando) quando l'elemento
	 * deve essere prelevato da un oggetto
	 * @param comando: stringa contenente il comando in input
	 * @throws NotFoundException: l'elemento non è presente nella camera
	 * @throws NotTakeableException: l'elemento non può essere preso
	 * @throws LockedException: l'oggetto da cui si desidera prendere l'elemento è bloccato
	 */
	private void prendiDa(String comando) throws NotFoundException, LockedException, NotTakeableException
	{
		String s = comando.substring(comando.indexOf(Gioco.getLingua().da()));
		
		Objects i = Room.getObject(s);
		if (i instanceof Openable)
		{
			if(((Openable) i).isOpen() && comando.contains(i.getOggetto().getName()))
			{
				Prendibile p = (Prendibile) i.getOggetto();
				p.prendi();
			}
			else
				throw new LockedException();
		}
		
		else
			throw new NotFoundException();
	}
	
	/**
	 * accarezza l'elemento
	 * @param comando: stringa contenente il comando in input
	 * @throws NotFoundException: l'elemento non può essere accarezzato o non è presente nella camera
	 */
	public void accarezza(String comando) throws NotFoundException
	{
		Characters a = Room.getCharacter(comando);
		
		if(a instanceof Accarezzabile)
		{
			((Accarezzabile)a).emettiVerso();
		}
		else
			throw new NotFoundException();
	}

	/**
	 * restituisce l'inventario del personaggio
	 */
	public void inventario()
	{
		System.out.println("-.-.-.-. INVENTARIO .-.-.-.-");
		System.out.println(getInventario().toString());
		System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
	}
	
	
	/**
	 * si utilizza un elemento
	 * @param comando: stringa contenente il comando in input
	 * @throws NotFoundException: elemento non trovato
	 * @throws NotUsableException: l'elemento non è @Usabile
	 * @throws LockedException: l'elmento è chiuso
	 * @throws NotCompatibleException
	 */
	public void usa(String comando) throws NotFoundException, NotUsableException, LockedException, NotCompatibleException
	{
		String[] token = comando.split("\\s+");
		boolean su = Arrays.stream(token).anyMatch(x->x.toLowerCase().equals(Gioco.getLingua().su()));
		if (su) 
			usaSu(comando);
		else
		{
			Linkable l = Room.getLinkable(comando);
			if (l instanceof Links) 
			{ 
				if (((Links)l).isOpen())
					l.vai(); 
				else
					throw new LockedException();
			}
			else
				throw new NotFoundException();
		}
	}
	
	/**
	 * il perosnaggio  utilizza un elemento su un altro elmento
	 * @param comando: stringa contenente il comando in input
	 * @throws NotFoundException: elemento non trovato
	 * @throws NotUsableException: l'elemento non è @Usabile
	 * @throws NotCompatibleException: i due elementi non sono comatibili
	 * @throws LockedException: l'elmento è chiuso
	 */
	private void usaSu(String comando) throws NotFoundException, NotUsableException, NotCompatibleException, LockedException
	{
		String[] s = comando.split(" "+Gioco.getLingua().su()+" ");
		Inventabile ob = fromInventario(s[0]);
		
		Usabile u = null;
		if (ob instanceof Usabile)
			u = (Usabile) ob;
		
		Objects i = Room.getObject(s[1]);
		if(u!=null && i!= null) { u.usa(i); return; }
		
		Linkable l = Room.getLinkable(s[1]);
		if(u!=null && l instanceof Links) { u.usa((Links) l); return; }
		
		if (u==null && i==null && l==null)
			throw new NotFoundException();
		else
			throw new NotUsableException();
	}
	
	/**
	 * Il peronaggio cede un elemento del suo inventario ad un altro personaggio
	 * @param comando: stringa contenente il comando in input
	 * @throws NotFoundException: personaggio o inventabile non trovati
	 * @throws NotLegalCommandException: il comando non è strutturato correttamente
	 */
	public void dai(String comando) throws NotFoundException, NotLegalCommandException
	{
		String[] token = comando.split("\\s+");
		boolean a = Arrays.stream(token).anyMatch(x->x.toLowerCase().equals(Gioco.getLingua().a()));
		if(a)
		{
			String[] s = comando.split(" "+Gioco.getLingua().a()+" ");
			Inventabile u = fromInventario(s[0]);
			
			Characters c = Room.getCharacter(s[1]);
			if (u!=null && c!=null)
			{
				u.dai(c);
				return;
			}
			
			throw new NotFoundException();
		}
		else
			throw new NotLegalCommandException();
	}
	
	/**
	 * Il personaggio entra in un @Linkable
	 * @param comando: stringa contenente il comando in input
	 * @throws NotFoundException: @Linkable non trovato
	 * @throws LockedException: @Linkable chiuso
	 */
	public void entra(String comando) throws NotFoundException, LockedException
	{
		Linkable l = Room.getLinkable(comando);
		
		if(l!=null)
		{
			l.vai();
		}
		else
			throw new NotFoundException();
	}
	
	/**
	 * il personaggio romape un elemento con un elemento del suo inventario
	 * @param comando: stringa contenente il comando in input
	 * @throws NotCompatibleException: i 2 elementi non sono compatibili
	 * @throws NotFoundException: elementi non trovati
	 * @throws NotLegalCommandException: il comando non è sgtrutturato correttamnete
	 */
	public void rompi(String comando) throws NotCompatibleException, NotFoundException, NotLegalCommandException
	{
		String[] token = comando.split("\\s+");
		boolean con = Arrays.stream(token).anyMatch(x->x.toLowerCase().equals(Gioco.getLingua().con()));
		if(con)
		{
			String[] s =  comando.split(" "+Gioco.getLingua().con()+" ");
			Objects i = Room.getObject(s[0]);
			Inventabile j = fromInventario(s[1]);
			
			if (j instanceof Usabile && i instanceof Rompibile)
			{
				((Usabile)j).usa(i);
			}
			else
				throw new NotFoundException();
		}
		else
			throw new NotLegalCommandException();
	}
	
	/**
	 * il personaggio parla con un altro personaggio
	 * @param comando: stringa contenente il comando in input
	 * @throws NotFoundException: personaggio non trovato o non si può parlare con esso
	 */
	public void parla(String comando) throws NotFoundException
	{
		Characters c = Room.getCharacter(comando);
		if (c instanceof Parlabile)
		{
			((Parlabile) c).parla();
		}
		else
			throw new NotFoundException();
	}
	
	/**
	 * getter di inventario
	 * @return inventario: @Inventable nell'inventario del giocatore
	 */
	public List<Inventabile> getInventario() {
		return inventario;
	}

	/**
	 * setter di inventario
	 * @param inventario: List<Inventabile> 
	 */
	public void setInventario(List<Inventabile> inventario) {
		this.inventario = inventario;
	}
	
	/**
	 * aggiunge un oggetto all'inventario
	 * @param i: @Inventabile
	 */
	public void addOggetto(Inventabile i) { inventario.add(i);}
	
	/**
	 * controlla se qualche elemento dell'inventario si trova nella stringa in input
	 * @param comando: stringa in input
	 * @return restituisce l'inventabile, se presente
	 */
	public Inventabile fromInventario(String comando) 
	{
		return getInventario()
				.stream()
				.filter(x->comando.contains(x.toString()))
				.max(Comparator.comparing(x->x.toString().length()))
				.orElse(null);
	}
	

}
