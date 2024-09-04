package it.uniroma1.textadv.characters;

import java.util.Comparator;
import java.util.List;

import it.uniroma1.textadv.Mondo;
import it.uniroma1.textadv.interfacce.Ingannabile;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Protetto;

/**
 * Modella la classe del guardiano
 *
 */
public class Guardiano extends Characters {
	private List<String> parametro;
	
	/**
	 * Costruttore della classe
	 * @param name: noem del guardiano
	 * @param parametro: elementi protetti dal guardiano
	 */
	public Guardiano(String name, String[] parametro) {
		super(name, parametro);
		this.parametro = List.of(parametro);
	}
	
	/**
	 * Se un oggetto che implementa l'interfaccia @Ingannabile ed è contenuto
	 * nella lista dei parametri del guardiano, egli si distra dimenticandosi di proteggere
	 * gli oggetti
	 */
	@Override
	public void addObject(Inventabile i)
	{
		super.addObject(i);
		if( i instanceof Ingannabile && parametro.contains(i.toString()))
				{
					Protetto p = (Protetto) Mondo.mondo.getRoom().getObjectsList().stream()
							.filter(x->x instanceof Protetto && parametro.contains(x.toString()))
							.max(Comparator.comparing(x->x.toString().length()))
							.orElse(null);
					if (p!=null)
						p.setPrendibile();
				}
	}

}
