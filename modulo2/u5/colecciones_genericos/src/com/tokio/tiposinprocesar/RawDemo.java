package com.tokio.tiposinprocesar;

public class RawDemo {

	public static void main(String[] args) {

		// Crea un objeto Gen para Enteros
		Gen<Integer> intGen = new Gen<Integer>(3);

		// Crea un objeto Gen para cadenas
		Gen<String> strGen = new Gen<String>("a");

		// Crea un objeto Gen sin procesar y le asingar un valor de double
		// Argumento sin tipo == Tipo sin procesar
		Gen raw = new Gen<Double>(3.0);
				
		// Un objeto sin procesar puede generar errores en ejecuion
		double d = (double) raw.getT(); // ok
		try {
			int i = (int) raw.getT(); // Error en ejecucion
		}catch(ClassCastException e) {
			e.printStackTrace();
		}
		
		// Se pueda anular la seguridad de tipos
		strGen = raw; // correcto pero no son el mismo tipo
		try {
			String str = strGen.getT(); // Error en ejecucion
				// str es de String y raw es Double
		}catch(ClassCastException e) {
			e.printStackTrace();
		}

		
		
		

	}

}
