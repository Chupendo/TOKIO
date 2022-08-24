package codes.exercicie.tokio;

import java.util.Scanner;

/**
 * Escribe un programa que permita al usuario introducir tantos números como desee.
 * Finalmente tendrá que mostrar por pantalla el número más alto.
 * 
 * @author Andres Ruiz Penuela
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i=0,gretter=0;
		boolean start=true;
		String tmp;
		do {
			System.out.print("Inserte un numero (. para salir): ");
			tmp = sc.nextLine();
			if(tmp.equals(".")) break;
			try {
				i = Integer.parseInt(tmp);
				if(start) {
					gretter = i;
					start=false;
				}
				else
					if(i>gretter) gretter = i;
			}catch(Exception ex) {
				System.err.println("No es un numero: "+ex);
			}
		}while(true);
		
		System.out.println("Numero mas alto introuducido: "+gretter);
	}
}
