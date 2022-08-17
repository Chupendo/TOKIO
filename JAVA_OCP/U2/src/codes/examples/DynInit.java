package codes.examples;

// Ilustra la inicializaci�n din�mica
public class DynInit {

	public static void main(String[] args) {
		double radius = 4, height = 5;
		
		// inicializaci�n volume de forma din�mica en tiempo de ejecuci�n
		double volume = Math.PI * Math.pow(radius, 2) * height;
		
		System.out.println("Volume is "+ volume);

	}

}
