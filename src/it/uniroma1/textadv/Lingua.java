package it.uniroma1.textadv;

/**
 * Enumerazione delle lingue del gioco
 *
 */
public enum Lingua {

	ITALIANO {
		@Override
		public Class getClasse() { return Player.class; }
		@Override
		public int getNumber() { return 0; }
	},
	INGLESE {
		@Override
		public Class getClasse() { return Inglese.class; }
		@Override
		public int getNumber() { return 1; }
	};

	/**
	 * metodo che restituisce la classe in cui cercare i comandi differenziata per lingua
	 * @return classe usata per cercare i comandi 
	 */
	public abstract Class getClasse();
	
	/**
	 * restituisce il numero che è associato alla lingua
	 * @return int associato alla lingua corrente
	 */
	public abstract int getNumber();
	
	/**
	 * restituisce la preposizione "da" nella lingua corrente del gioco
	 * @return Stringa della preposizione
	 */
	public String da() { return Inglese.da[this.getNumber()]; }
	
	/**
	 * restituisce la preposizione "con" nella lingua corrente del gioco
	 * @return Stringa della preposizione
	 */
	public String con() { return Inglese.con[this.getNumber()]; }
	
	/**
	 * restituisce la preposizione "a" nella lingua corrente del gioco
	 * @return Stringa della preposizione
	 */
	public String a() { return Inglese.a[this.getNumber()]; }
	
	/**
	 * restituisce la preposizione "su" nella lingua corrente del gioco
	 * @return Stringa della preposizione
	 */
	public String su() { return Inglese.su[this.getNumber()]; }
}
