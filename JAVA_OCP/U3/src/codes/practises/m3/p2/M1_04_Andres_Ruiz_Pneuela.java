package codes.practises.m3.p2;

import java.util.Scanner;

/**
 * Crear un programa que lea caracteres desde teclado indefinidamente. Requisitos:
 *  1. El programa pedirá al usuario que inserte caracteres o frases completas por teclado de manera indefinida
 *  2. El programa contará el número de espacios que se van introduciendo por consola
 *  3. El programa finalizará cuando el usuario introduzca un punto “.”
 *  4. El programa imprimirá por consola el número total de espacios que se han introducido
 *
 * @version 1.0.0
 * @author Andres Ruiz Penuela
 * 
**/
public class M1_04_Andres_Ruiz_Pneuela {

	public static void main(String[] args) {
		String texto;
		short numeroSpacios = 0;
		
		texto = capturaString("Inserte un mensaje (. para salir): ");
		numeroSpacios = contarEspacios(texto);
		
		
		System.out.println("Mensaje introducido: "+texto);
		System.out.println("Numero de espacios: "+numeroSpacios);
	}
	
	/** 
	 * Metodo que caputra un string y deuvelve un texto introducido por el usuario.
	 * El texto pide una cpatura hasta que inserte un .
	 * 
	 * @param msg
	 * 		String de texto a mostrar con la solicitud 
	 * @return data
	 * 		String texto introducido por el usuario
	 */
	public static String capturaString(String msg) {
		Scanner sc = new Scanner(System.in);
		StringBuilder data = new StringBuilder();
		
		do {
			System.out.print(msg+data);
			data.append(sc.nextLine());
			if((data.charAt(data.length()-1)=='.')) {
				break;
			}
		}while(true);
		
		return data.toString();
	}
	
	/**
	 * Método que deuvelve el numero de espacios que contiente el texto recibido
	 * 
	 * @param texto
	 *		String con el  texto a aanalizar
	 * @return numero
	 * 		short numero de espacios
	 */
	public static short contarEspacios(String texto) {
		// Separa el String en espacios
		// El de espacioes es el numero de elementos - 1
		short numero = (short) (texto.split(" ").length-1);
		return numero;
	}
}
