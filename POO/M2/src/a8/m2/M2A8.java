package a8.m2;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Realizamos un programa Java que nos indique si el número que introducimos mediante teclado es o no primo.
 * 
 * Recordemos que un número primo es aquel que solamente es divisible por si mismo y por launidad.
 * El número tendrá que ser mayor que 0 y menor que 100.
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0.0
 *
 */
public class M2A8 {

	public static void main(String[] args) {
		int numero=0;
		Scanner sc = new Scanner(System.in);
		
		do {
			try {
				System.out.print("Un numero en el intervalo (0,100): ");
				numero = sc.nextInt();
				if(numero>0&&numero<100) {
					System.out.println("Es primo: "+isPrimo(numero));
				}else {
					System.err.println("Fuera del intervalo.");
				}
			} catch (NoSuchElementException | IllegalStateException ex) {
				System.err.println("No es un numero - " + ex);
				numero = -1;
				sc.nextLine();
			}
		}while(numero<=0||numero>=100);
	}
	
	/**
	 * Función que indica si un numero dado es primo o no
	 * 
	 * @param resutlado:boolean
	 */
	public static boolean isPrimo(int num) {
		// El 0, 1 y 4 no son primos
		if (num == 0 || num == 1 || num == 4) {
			return false;
		}
		
		//Dividimos (division entera) el número desde 2 hasta la mita del numero, si sale 0 no es primo
		for (int x = 2; x < num / 2; x++) {
			// Si es divisible por cualquiera de estos números, no
		    // es primo
		    if (num % x == 0)
		      return false;
		}
		// Si no se pudo dividir por ninguno de los de arriba, sí es primo
		return true;
	}

}
