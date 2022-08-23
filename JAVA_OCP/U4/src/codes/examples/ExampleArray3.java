package codes.examples;

import java.io.IOException;
import java.util.Scanner;

public class ExampleArray3 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		// Inicializacion de matriz bidimensioanl
		int table[][] = new int[3][];
		table[0] = new int[4];
		table[1] = new int[4];
		table[2] = new int[4];

		// Declarcion de una matriz de una matriz bidimensional irregular
		int[][] viajeros = new int[7][];
		
		
		// Inicializacion de una matriz irregular
		int pasajero = 0;
		String temp;
		for (int i = 0; i < viajeros.length; i++) {
			do {
				System.out.print("Dia de la semena: "+i+", numero de pasajeros (. para salir): ");
				try {
					temp = sc.nextLine();
					if (temp.equals(".") && viajeros[i] != null) {
						break;
					}else {
						if (temp.equals(".") && viajeros[i] == null)
							System.err.println("No esta inicializada correctamente");
					}

					if (!temp.equals(".")) {
						pasajero = Integer.parseInt(temp);
						viajeros[i] = new int[pasajero];
					}
				} catch (Exception ex) {
					System.err.println("No es un numero " + ex);
				}

			} while (true);
		}

		// Acceso a los elemnetos
		for (int semana[] : viajeros) {
			if(semana!=null) {
				for (int viajero : semana) {
					System.out.print(viajero);
				}
			}
			System.out.println();
		}
		
	}
}
