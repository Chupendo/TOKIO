package estructuraForEach;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		List<String> listaNombres = new ArrayList();
        listaNombres.add("Mercedes");
        listaNombres.add("Ricardo");
        listaNombres.add("Ana");

		for(String nombre: listaNombres) {
			System.out.println("Nombre: "+nombre);
		}
	}
}
