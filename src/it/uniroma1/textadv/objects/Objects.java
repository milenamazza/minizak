package it.uniroma1.textadv.objects;

import it.uniroma1.textadv.WorldBuilder;
import it.uniroma1.textadv.eccezioni.creazione.AlreadyPositioned;
import it.uniroma1.textadv.interfacce.Inventabile;

/**
 * modella i tipi di oggetti presenti all'interno del gioco
 */
public abstract class Objects {

	protected String name;
	protected Objects oggetto;
	
	/**
	 * costruttore della classe tramite stringa e array dei parametri con cui l'oggetto può interagire
	 * @param name: nome dell'oggetto
	 * @param parametro
	 */
	public Objects(String name, String[] parametro) {
		this.name = name;
		if (parametro!=null)
		{
			WorldBuilder.parametri.put(this, parametro[0]);
		}
	}

	/**
	 * restituisce il nome dell'oggetto
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * getter della descriscrizione
	 * @return String descrizione
	 */
	public String getDescription()
	{
		return "L'oggetto è: " + getName();
	}
	
	/**
	 * Posiziona il parametro dell'oggetto attraverso la mappa del wb associata
	 * agli oggetti, se questo non è trovato viene sollevata un'eccezione
	 * @param wb: builder del mondo
	 * @throws AlreadyPositioned: due elementi con lo stesso nome
	 */
	public void setOggetto( WorldBuilder wb) throws AlreadyPositioned
	{		
		String o = wb.parametri.get(this);
		if ( o != null)
		{
			oggetto = wb.objects.get(o);
			if (oggetto == null && !wb.links.containsKey(o))
				throw new AlreadyPositioned();
			else
			{
				wb.parametri.remove(o);
				wb.objects.get(o);
			}
		}
		
	}
	
	/**
	 * getter di oggetto
	 */
	public Objects getOggetto()
	{
		return oggetto;
	}
	
	/**
	 * cambia il parametro dell'oggetto
	 * @param o: nuovo elemento da associare all'oggetto
	 */
	public void changeObject(Objects o)
	{
		oggetto = o;
	}
	
	/**
	 * Override del metodo toString della classe Object
	 */
	@Override
	public String toString() { return name; }
	
	
}
