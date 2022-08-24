package codes.exercicie.tokio;

import java.util.Scanner;

/**
 * Escribe un programa que, partiendo de una lista de palabras, busque una
 * introducida por el usuario e indique si está o no endicha lista.
 * 
 * @author Andres Ruiz Penuela
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cadena = "Se conoce como texto al conjunto de frases y palabras coherentes y ordenadas que permiten ser interpretadas y transmiten las ideas de un autor (emisor o locutor). La palabra texto es de origen latín textus que significa tejido.";
		String word;
		boolean encontrada = false;
		
		System.out.print("Inserte la palabra a buscar: ");
		word = sc.nextLine();
		
		encontrada = cadena.contains(word);
		System.out.println("cadena: "+cadena);
		System.out.println("¿\""+word+"\" esta cadena? "+encontrada);
	}
}