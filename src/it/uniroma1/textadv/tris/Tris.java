package it.uniroma1.textadv.tris;

import java.util.Random;
import java.util.Scanner;
import java.util.Random;

/**
 * La classe modella il gioco del Tris
 *
 */
public class Tris {

	public static final int MAX = 3;
	public static final int MIN = 0;
	private static int mosse = MIN;
	
	/**
	 * Enumerazione dei giocatori
	 *
	 */
	public enum Giocatore
	{
		X,
		O;
	}
	
	/**
	 * metodo che avvia e gestisce il gioco
	 */
	public static void gioca() {
		
		Giocatore[][] schema = new Giocatore[MAX][MAX];

		inizializza(schema);

		boolean vittoriaX=false;
		boolean vittoriaO=false;
		
		Giocatore turno=Giocatore.X;
		
		while (mosse<MAX*MAX && !vittoriaX && !vittoriaO) {

			visualizza(schema);

			mosse++;
			
			if (turno.equals(Giocatore.X)) 
			{
				nuovaMossa(schema, turno);
				vittoriaX = haVinto(schema, Giocatore.X);
			}
			else 
			{
				nuovaMossaPc(schema, turno);
				vittoriaO = haVinto(schema, Giocatore.O);
			}

			turno = turno.equals(Giocatore.X)?Giocatore.O:Giocatore.X;
			
		}
		
		visualizza(schema);

		if (vittoriaX) System.out.println("COMPLIMENTI X, HAI VINTO!!!");
		else if (vittoriaO) System.out.println("COMPLIMENTI O, HAI VINTO!!!");
		else System.out.println("PAREGGIO!");
		
	}
	
	/**
	 * Inizializza il tabellone
	 * @param schema: Tabellone di gioco
	 */
	private static void inizializza(Giocatore[][] schema) {
		for (int i=MIN; i<MAX; i++)
			for (int j=MIN; j<MAX; j++)
				schema[i][j] = null;
	}
	
	/**
	 * stampa a schermo il tabellone
	 * @param schema: Tabellone di gioco
	 */
	private static void visualizza(Giocatore[][] schema) {
		for (int i=MIN; i<MAX; i++) {
			System.out.println(" -------------");
			for (int j=MIN; j<MAX; j++) {
				String s = schema[i][j]==null? " ": schema[i][j].toString();
				System.out.print(" | " + s);
			}
			System.out.println(" |");
		}
		System.out.println(" -------------");
	}

	/**
	 * gestisce la nuova mossa del giocatore interattivo
	 * @param schema: Tabellone di gioco
	 * @param turno: enumerazione del giocatore che ne stabilisce il turno
	 */
	private static void nuovaMossa(Giocatore[][] schema, Giocatore turno) {
		
		Scanner input = new Scanner(System.in);
		
		int riga, colonna;
		boolean valida;
		
		do {
			
			valida = true;
			
			System.out.println("[Turno " + turno + "] Inserisci riga e colonna della mossa");
			riga = input.nextInt();
			colonna = input.nextInt();
			
			try {
				if (riga<MIN || riga>MAX-1 || colonna<MIN || colonna>MAX-1) 
				{
					valida = false;
					throw new OutOfRangeException();
				}
				else if (schema[riga][colonna]!=null) 
				{
					valida=false;
					throw new BusyException();
				}
			}catch(OutOfRangeException | BusyException e )
				{
					System.out.println(e.getMessage());
				}
		} while (!valida);

		schema[riga][colonna] = turno;
	}
	
	/**
	 * gestisce la mossa dell'avversario
	 * @param schema: Tabellone di gioco
	 * @param turno: enumerazione del giocatore che ne stabilisce il turno
	 */
	private static void nuovaMossaPc(Giocatore[][] schema, Giocatore turno)
	{
		int riga, colonna;
		Random random = new Random();
		boolean valida;
		
		do {
			valida = true;
			
			riga = random.nextInt(MAX);
			colonna = random.nextInt(MAX);
			
			if (schema[riga][colonna]!=null)
					valida=false;
		}while (!valida);
			
		schema[riga][colonna] = turno;
	}
	

	/**
	 * Controlla se il giocatore ha VINTO
	 * @param schema: Tabellone di gioco
	 * @param c: giocatore di cui si controlla la vittoria
	 * @return
	 */
	private static boolean haVinto(Giocatore[][] schema, Giocatore c) {
		
		boolean ris=false;
		
		// controlla tutte le righe
		for (int i=MIN; i<MAX; i++)
			if ( schema[i][0]==c && schema[i][1]==c && schema[i][2]==c) ris = true;
		
		// controlla tutte le colonne
		for (int i=MIN; i<MAX; i++)
			if ( schema[0][i]==c && schema[1][i]==c && schema[2][i]==c) ris = true;
		
		// controlla le diagonali
		if ( schema[0][0]==c && schema[1][1]==c && schema[2][2]==c) ris = true;
		if ( schema[0][2]==c && schema[1][1]==c && schema[2][0]==c) ris = true;
		
		return ris;
	}
}
