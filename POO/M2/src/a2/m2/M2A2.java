package a2.m2;

import java.io.IOException;
import java.util.Scanner;

/**
 * Creamos un programa Java que verifique una contrase�a a elegir por el usuario.
 * Si se realiza nm�s de 3 intentos err�neos, el programa mostrar �un mensaje al usuario e inmediatamente finalizar�.
 *
 * @author Andr�s Ruiz Pe�uela
 * @version 1.0.0
 *
 */
public class M2A2 {
	static final int  N_ATTEMPT=3; //Numero de intnetos
	
	public static void main(String[] args) {
		//Definici�n e Inicializaci�n de variables
		String secret = "",capture="";
		short attempt=0;
		Scanner sc = new Scanner(System.in);
		
		//Caputra de la constrase�a
		System.out.print("Inserte la contrase�a: ");
		secret=sc.nextLine();
		
		//Limpia la consola
		cls();
		
		//Verifica el secretro
		while(attempt<3){
			System.out.print("Vuelve a insertar la contra�sea ("+(3-attempt)+" intentos): ");
			capture=sc.nextLine();
			if(capture.equals(secret)) {
				System.out.println("Correcto.");
				attempt=3;
			}else {
				System.err.println("Error.");
				attempt++;
			}
		}//fin for
		
	}
	
	public static void cls(){
	    try {

	     if (System.getProperty("os.name").contains("Windows"))
	         new ProcessBuilder("cmd", "/c", 
	                  "cls").inheritIO().start().waitFor();
	     else
	         Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {
	    	System.err.println("No se puede limpiar el terminal: "+ex);
	    }
	}
}
