package estructuraWhileDoWhile;

import java.util.Scanner;

/**
 * Realizar un programa Java que nos solicite una palabra por teclado continuamente hasta 
 * que introduzcamos la palabra “coche”. 
 * 
 * Mientras fallemos, mostrará el mensaje: “¡ERROR!, Introduce otra palabra:”
 * En cambio, si acertamos, mostrará el mensaje: “¡BIEN!, por fin has acertado!!!
 * @author andre
 *
 */
public class EjemploWhile {

	public static void main(String[] args) {
        String word="";
        Scanner sc = new Scanner(System.in);
        while(!word.equals("coche")) {
        	System.out.print("Inserte una plabra: ");
        	word = sc.nextLine();
        	if(!word.equals("coche")) {
        		System.out.println("¡ERROR!, Introduce otra palabra: "+word);
        	}
        }
        
        System.out.println("¡BIEN!, por fin has acertado!!!");
    }

}
