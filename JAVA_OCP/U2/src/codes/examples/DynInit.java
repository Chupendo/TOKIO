package codes.examples;

// Ilustra la inicialización dinámica
public class DynInit {

	public static void main(String[] args) {
		double radius = 4, height = 5;
		
		// inicialización volume de forma dinámica en tiempo de ejecución
		double volume = Math.PI * Math.pow(radius, 2) * height;
		
		System.out.println("Volume is "+ volume);

	}

}
