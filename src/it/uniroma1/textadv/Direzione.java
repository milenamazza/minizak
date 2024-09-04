package it.uniroma1.textadv;

/**
 *  enumerazione delle possibili direzioni in cui il giocatore può muoversi
 *
 */
public enum Direzione {
	N,
	S,
	E,
	O,
	EST			{@Override public Direzione converti() {return Direzione.E;}},
	OVEST		{@Override public Direzione converti() {return Direzione.O;}},
	NORD		{@Override public Direzione converti() {return Direzione.N;}},
	SUD			{@Override public Direzione converti() {return Direzione.S;}},
	NORTH		{@Override public Direzione converti() {return Direzione.N;}},
	SOUTH		{@Override public Direzione converti() {return Direzione.S;}},
	WEST 		{@Override public Direzione converti() {return Direzione.O;}},
	W 			{@Override public Direzione converti() {return Direzione.O;}};
	
	/**
	 * converte le direzioni in input con quelle salvate nelle mappe
	 * @return
	 */
	public Direzione converti() {return this;}
}
