package estructuraWhileDoWhile;

import java.util.Scanner;

/**
 * Se debe reproducir por pantalla un men� de dos opciones hasta que la opci�n tecleada sea igual a 3.
 * @author andre
 *
 */
public class EjemploDoWhile {

	public static void main(String[] args) {
		int opcion=0;
		Scanner sc = new Scanner(System.in);
		
		do {
			 System.out.println("1. Opcion men� 1.");
			 System.out.println("1. Opcion men� 2.");
			 System.out.print("Teclea opci�n 1 o 2. Pulsa 3 para SALIR: ");
			 opcion = sc.nextInt();
		}while(opcion!=3);

	}
}
