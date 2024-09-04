package it.uniroma1.textadv.characters;
import java.util.List;
import java.util.stream.Collectors;

import it.uniroma1.textadv.Mondo;
import it.uniroma1.textadv.eccezioni.notTakeableException.NotTakeableException;
import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.interfacce.Inventabile;
import it.uniroma1.textadv.interfacce.Pagabile;
import it.uniroma1.textadv.interfacce.Prendibile;
import it.uniroma1.textadv.objects.Soldi;

/**
 * Modella la classe del Venditore
 *
 */
public class Venditore extends Characters {
	
	private List<String> vendita;
	
	/**
	 * Costruttore della classe
	 * @param name: nome del venditore
	 * @param parametro: lista degli oggetti che vende
	 */
	public Venditore(String name, String[] parametro) {
		super(name, parametro);
		vendita = List.of(parametro);
	}
	
	/**
	 * Quando il venditore riceve dei soldi, consegna gli oggetti che vende
	 * al personaggio
	 */
	@Override
	public void addObject(Inventabile i)
	{
		super.addObject(i);
		if( i instanceof Soldi)
		{
			Mondo.mondo.getRoom().getObjectsList().stream()
			.filter(x -> vendita.contains(x.getName()) && x instanceof Pagabile)
			.map(x->(Pagabile) x)
			.forEach(x-> x.setPagato());
			
			List<Prendibile> l = Mondo.mondo.getRoom().getObjectsList().stream()
			.filter(x -> vendita.contains(x.getName()) && x instanceof Prendibile)
			.map(x->(Prendibile) x)
			.collect(Collectors.toList());
			
			l.forEach(x->{
				try {
					x.prendi();
				} catch (NotTakeableException | LockedException e) {
				}
			});
			
		}
	
	}
	
}
