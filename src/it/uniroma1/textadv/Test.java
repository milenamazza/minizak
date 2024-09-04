package it.uniroma1.textadv;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Classe di test del gioco
 *
 */
public class Test
{
	
	/**
	 * main
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		
		Gioco g = new Gioco();
		Mondo m = Mondo.fromFile("minizak.game");
		//g.localizza(Lingua.INGLESE);
		Path scriptDiGioco = Paths.get("minizak.ff");
		g.play(m, scriptDiGioco);
		//g.play(m);

//		Storia
//		Gioco g = new Gioco();
//		Mondo m = Mondo.fromFile("storia.game");
//		Path scriptDiGioco = Paths.get("storia.ff");
//		g.play(m, scriptDiGioco);

	}
}
