package codes.examples;

public class ExampleArray1 {

	public static void main(String[] args) {
		int[] numeros;

		numeros = new int[3];

		double[] reales = { 3.2, 42.2 };

		// Recorrer
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = i + 1;
		}

		for (double real : reales) {
			real = Math.random() + 1;
		}
	}

}
