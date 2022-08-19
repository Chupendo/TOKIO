package codes.examples;

import java.util.Scanner;

public class EjemploSwitchCase {
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Men�");
		System.out.println("a. Opci�n a");
		System.out.println("b. Opci�n b");
		System.out.println("c. Opci�n c");
		System.out.println("d. Opci�n d");

		// Introducci�n del valor de la variable
		System.out.print("Introduce una opci�n: ");
		String opcion = teclado.nextLine();

		switch (opcion) {

		case "a": // Primer valor
			System.out.println("Has escogido la opcion a");
			break; // Instrucci�n que nos sacar� del bucle

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
		System.out.println("Aqu� sigo despu�s del switch-case");
	}
}
