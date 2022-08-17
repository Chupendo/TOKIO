import java.util.Scanner;


/**
 * M�dulo 1. Actividad 5. Realizar un primer programa Java con Eclipse. Pedir un
 * nombre por consola y devolverlo sacando el mensaje "HelloWorld:" + Nombre
 * le�do.
 * 
 * @author Andr�s Ruiz Pe�uela
 * @version 1.0, 22/04/22
 * 
 */
public class Main {

	/**
	 * M�todo principal, es lanzado al iniciar el programa y tiene la funcionalidad
	 * de solicitar el nombre por consola y capturarlo, mostrando como resultado el
	 * mensaje por consola "Hello World: "+nombre
	 * 
	 * @param args argumentos de entrada al ejecutiar el programa
	 */
	public static void main(String[] args) {
		// init var
		Scanner sc = new Scanner(System.in);
		String name = null;

		// Capture
		System.out.print("Introduzca su nombre: ");
		name = sc.nextLine();

		// Show
		System.out.println("Hello World: " + name);
	}

}
