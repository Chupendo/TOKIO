package codes.examples;

public class EjemploWhile {

	public static void main(String[] args) {
		// Declaraci�n de variables
		int i = 0;
		int suma = 0;

		// Inicio del ciclo while con su condici�n
		while (i < 10) {
			suma = suma + i;
			i += 1;
		} // Fin del bucle while
		System.out.println(suma);
		System.out.println("Aqui termina el programa");
	}

}
