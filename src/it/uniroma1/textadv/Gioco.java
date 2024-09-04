package it.uniroma1.textadv;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * La classe gestisce l'inizio e la fine del gioco
 *
 */
public class Gioco {

	private static Lingua lingua = Lingua.ITALIANO;

	/**
	 * avvia il gioco e ne gestisce la fine
	 * @param m 
	 */
	public void play(Mondo m) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println(m.getDescription());
		
		while (!m.getVittoria())
		{
			String command = s.nextLine();
			MotoreVirtuale.elabora(command);
		}
		
		System.out.println("VITTORIA!");
		s.close();
	}

	/**
	 * avvia il gioco fastforward
	 * @param m
	 * @param scriptDiGioco è il file da cui vengono prelevate le informazioni
	 */
	public void play(Mondo m, Path scriptDiGioco) {
		try {
				Scanner s =  new Scanner(scriptDiGioco);
				System.out.println(m.getDescription());
				
				while(s.hasNextLine() && !m.getVittoria())
				{
					String line = s.nextLine();
					if (line.contains("//"))
						line = line.split("//")[0];
					MotoreVirtuale.elabora(line);
					
				}
				s.close();
				if (m.getVittoria())
					System.out.println("VITTORIA!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Permette di scegliere la lingua in cui settare i comandi
	 * @param lingua
	 */
	public static void localizza(Lingua lingua)
	{
		Gioco.lingua = lingua;
	}
	
	/**
	 * restituisce la lingua in cui sono settate i comandi in input
	 * @return
	 */
	public static Lingua getLingua()
	{
		return lingua;
	}
	
}
