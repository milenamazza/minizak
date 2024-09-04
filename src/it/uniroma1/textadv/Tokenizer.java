package it.uniroma1.textadv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe che divide in settori il file della descrizione del mondo
 * @author milli
 *
 */
public class Tokenizer 
{
	/**
	 * Metodo che legge il testo dal file e gestendo le varie righe vuote va a suddividerlo in blocchi e lo inserisce all'interno di un arrayList in modo da poterci poi lavorare  
	 * @param nomeFile
	 * @return
	 */
	
	public static Map<Elementi,ArrayList<String>> read(String nomeFile) {

			BufferedReader reader;
			HashMap<Elementi , ArrayList<String>> blocchiEsecuzione = new HashMap<Elementi , ArrayList<String>>();
			try {
				reader = new BufferedReader(new FileReader(nomeFile));
				String riga = reader.readLine();
				String blocco = ""; 
				while (riga != null) {				
					
					if(!riga.isEmpty()) 
					{
						blocco+=riga+"\n";
					}
					
					else if (!blocco.equals("")) 
					{						
						String[] b = blocco.substring(blocco.indexOf("[") + 1, blocco.indexOf("]")).split("\\:");	
						blocchiEsecuzione.computeIfAbsent(Elementi.valueOf(b[0].toUpperCase()), 
								k -> new ArrayList<String>()).add(blocco);
						blocco = "";
					}
					riga = reader.readLine();
				}
				
				if (!blocco.equals(""))
				{
						String[] b = blocco.substring(blocco.indexOf("[") + 1, blocco.indexOf("]")).split("\\:");	
						blocchiEsecuzione.computeIfAbsent(Elementi.valueOf(b[0].toUpperCase()),
								k -> new ArrayList<String>()).add(blocco);
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return blocchiEsecuzione;
		}
}
