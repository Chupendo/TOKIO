package examples.heredity.u6.m1.example2;



/**
 * Ejemplo 2 de Herencia, explicación del acceso a los comportamientos de la
 * clase derivada a la clase base.
 * 
 * - Una clase derivada puede acceder a todos los comportamientos publicos y
 * protegidos (protected + friendly) de la clase base si se encuentra en el
 * mismo paquete
 * 
 * - Una clase derivada puede acceder a todos los comportamientos publicos y
 * protegidos (protected ) de la clase base si se encuentra en paquetes
 * diferentes.
 * 
 * - Una clase privada solo puede ser cuando esta está dentro de otra
 * clase (inner-class), por lo que no son visibles por clases externas
 * Una clase derivada puede sobrescribir los comportamientos de la clase base
 * 
 * @author Andres Ruiz Peñuela
 * @version 1.0
 *
 */
public class Example2 {
	/**
	 * Clase Vehiculo de tipo pbulica
	 */
	public static class Vehiculo {
		int ruedas; // friendly o package
		private String modelo; // privado
		protected String matricula; // protegico

		/** Iniciliaza un objeto de la clase Vehiculo **/
		public Vehiculo(int ruedas, String modelo, String matricula) {
			super();
			this.ruedas = ruedas;
			this.modelo = modelo;
			this.matricula = matricula;
		}

		public String getMatricula() {
			return matricula;
		}

		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

		/** Método sobrescirto de la clase base "Object" **/
		@Override
		public String toString() {
			return "Vehiculo [ruedas=" + ruedas + ", modelo=" + modelo + ", matricula=" + matricula + "]";
		}
	}// Fin class Vehiculo

	/**
	 * Clase Camion extiende de Vehiuclo de tipo privada
	 */
	private static class Camion extends Vehiculo {
		double peso;
		int puertas;
		
		Camion(int ruedas, String modelo, String matricula, int puertas, double peso){
	        	// Llamada al constructor de la clase base
	        	super(ruedas, modelo, matricula);
	        	this.puertas = puertas;
	        	this.peso =peso;
	     }

		@Override
		public String toString() {
			return "Camion [peso=" + peso + ", puertas=" + puertas + ", ruedas=" + ruedas + ", matricula=" + matricula
					+ "]";
		}
	}// Fin class Camion

	/**
	 * Clase Coche extiende de Vehiculo protected o friendly
	 */
	static class Coche extends Vehiculo {
		// Extensión de la clase base
		int puertas;

		Coche(int ruedas, String modelo, String matricula, int puertas) {
			// Llamada al constructor de la clase base
			super(ruedas, modelo, matricula);
			this.puertas = puertas;
		}

		/** Método sobrescirto de la clase base "Vehiculo" **/
		@Override
		public String toString() {
			// Acceso directo a los atributos de la clase base publicos//protected
			return "Coche [puertas=" + puertas + ", ruedas=" + ruedas + ", matricula=" + matricula + ", getMatricula()="
					+ getMatricula() + "]";
		}
	}// Fin class Coche

	/**
	 * Uso de las clase 
	 */
	public static void main(String args[]) {

		// Coche herada los comportamientos de la clase base
		// más sus comportamientos
		Coche cr1 = new Coche(5, "Kia Rio", "0000AFD", 4);
		Camion cm1 = new Camion(4, "Vita", "90432JFK", 3, 7650.80);
		
		System.out.println(cr1.toString());
		System.out.println(cm1.toString());
	}
}