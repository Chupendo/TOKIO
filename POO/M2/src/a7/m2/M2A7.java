package a7.m2;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Pedir al usuario una nota del 0 al 10 y mostrarla de la forma: Insuficiente,
 * Suficiente, Bien, Notable o Sobresaliente.
 * 
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0.0
 *
 */
public class M2A7 {

	// Lista enumerada de notas
	public static enum type {
		Insuficiente, Suficiente, Bien, Notable, Sobresaliente
	};

	public static void main(String[] args) {

		// Declaracion e inicializacion de variables
		int nota = 0;
		Scanner sc = new Scanner(System.in);

		// Captura y traduccion de nota
		do {
			try {
				// Solicitmaos la nota
				System.out.print("Inserte su nota: ");
				nota = sc.nextInt();

				// Obtener el equivalnte de la nota
				transcript(nota);

			} catch (NoSuchElementException | IllegalStateException ex) {
				System.err.println("No es un numero - " + ex);
				nota = -1;
				sc.nextLine();
			}
		} while (nota < 0 || nota > 10);

	}

	/**
	 * Función que convierte el valor de la nota a un tipo de nota
	 * 
	 * @param nota: int
	 */
	public static void transcript(int nota) {
		switch (nota) {
		case 0, 1, 2, 3, 4:
			System.out.println(type.Insuficiente);
			break;
		case 5:
			System.out.println(type.Suficiente);
			break;
		case 6:
			System.out.println(type.Bien);
			break;
		case 7, 8:
			System.out.println(type.Notable);
			break;
		case 9, 10:
			System.out.println(type.Sobresaliente);
		default:
			System.out.println("Unknown! Attempt repeat again.");
		}
	}
}
