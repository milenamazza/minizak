package it.uniroma1.textadv;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import it.uniroma1.textadv.eccezioni.NotFoundException;

/**
 * Classe che computa i singoli comandi
 * @author milli
 *
 */
public class MotoreVirtuale 
{
	/**
	 * elabora il comando e tramite reflection invoca il metodo appropriato
	 * @param comando
	 */
	public static void elabora(String comando)
	{
		String[] parametri = comando.split("\\s+");
		String nomeMetodo = parametri[0];

		try {
			
			Class c = Gioco.getLingua().getClasse();
			
			if(parametri.length > 1)
			{
				Method m = c.getMethod(nomeMetodo, String.class);
				Object[] array = new Object[] {comando};
				m.invoke(Player.getIstance(), array);
			}
			else
			{
				Method m = c.getMethod(nomeMetodo);
				m.invoke(Player.getIstance());
			}
		} catch (InvocationTargetException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException e) {
			System.out.println("Comando non ammesso");
		}
	}
}
