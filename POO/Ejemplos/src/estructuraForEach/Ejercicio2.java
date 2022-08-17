package estructuraForEach;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * calcular la suma de los números pares comprendidos entre 1 y 20.
 * @author andre
 *
 */
public class Ejercicio2 {

	//Mi solución
	public static void main(String[] args) {
		 Map<String, Coche> garaje = new HashMap();

	     garaje.put("7896KKM", new Coche("FORD","MONDEO","NEGRO"));
	     garaje.put("5866JPH", new Coche("FORD","KUGA","VERDE"));
	     garaje.put("1200LBC", new Coche("FIAT","PUNTO","ROJO"));
	     garaje.put("9988KMN", new Coche("NISSAN","JUKE","NARANJA"));
	     
	     //Opcion 1
	     System.out.println("Opcion 1.");
	     Set<String> keys = garaje.keySet();
	     for(String key: keys) {
	    	 System.out.println(garaje.get(key));
	     }
	     
	   //Opcion 2
	     System.out.println("Opcion 2.");
	     for(Map.Entry<String, Coche> coche: garaje.entrySet()) {
	    	 System.out.println("key= "+coche.getKey());
	    	 System.out.println("Value= "+coche.getValue());
	     }
	}
}
