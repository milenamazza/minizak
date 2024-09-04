package it.uniroma1.textadv.Aperture;

import it.uniroma1.textadv.eccezioni.openingException.LockedException;
import it.uniroma1.textadv.eccezioni.openingException.OpeningException;
import it.uniroma1.textadv.interfacce.Openable;
import it.uniroma1.textadv.interfacce.OpenableWith;
import it.uniroma1.textadv.objects.Objects;

/**
 * Questa interfaccia è implementa dai tipi di serratura possibili
 *
 */
public interface Apertura
{
	/**
	 * il metodo prende il input un @Openable e prova 
	 * ad aprirlo senza utilizzare alcun oggetto
	 * @param o: @Openable da aprire
	 * @throws OpeningException: viene sollevata se l'elemento non
	 * viene aperto
	 */
	void open(Openable o) throws OpeningException ;
	
	/**
	 * Il metodo codifica il comportamento della serratura se la si 
	 * prova ad aprire con un oggetto
	 * @param comando: Striga in input
	 * @param ob: Oggetto corretto con cui si dovrebbe aprire al serratura
	 * @param o: @Openable da aprire
	 * @throws OpeningException: viene sollevata se l'elemento non
	 * viene aperto
	 */
	void openWith(String comando, Objects ob, Openable o) throws OpeningException;
}
