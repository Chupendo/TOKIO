package codes.examples;

import java.util.Scanner;

public class EjemploSwitchCase {
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Menú");
		System.out.println("a. Opción a");
		System.out.println("b. Opción b");
		System.out.println("c. Opción c");
		System.out.println("d. Opción d");

		// Introducción del valor de la variable
		System.out.print("Introduce una opción: ");
		String opcion = teclado.nextLine();

		switch (opcion) {

		case "a": // Primer valor
			System.out.println("Has escogido la opcion a");
			break; // Instrucción que nos sacará del bucle

		case "b": // Segundo valor
			System.out.println("Has escogido la opcion b");
			break;

		case "c": // Tercero valor
			System.out.println("Has escogido la opcion c");
			break;

		case "d": // Cuarto valor
			System.out.println("Has escogido la opcion d");
			break;
		}
		System.out.println("Aquí sigo después del switch-case");
	}
}
