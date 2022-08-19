package codes.practices;

import java.util.Scanner;
import java.util.function.BiFunction;

/**
 * Crear un programa que realice algunas operaciones matemáticas. 
 * 
 * 1. Pedir por consola al usuario que introduzca 3 números enteros y almacenar su valor en variables. 
 * 2. Operación 1 (a*b/c) Mostrar por consola el resultado 
 * 3. Operación 2 (a*c)%b Mostrar por consola el resultado 
 * 4. Operación 3 2*(a+c-b)/(b*c) Mostrar por consola el resultado 
 * 5. Operación 4 ((a*c)+(b%a))/a-c Mostrar por consola el resultado 
 * 6. Opcional: Repetir las operaciones con números decimales para ver las diferencias de resultado.
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0.0
 *
 */
public class M1_02_Andres_Ruiz_Penuela {

	/**
	 * Método principal
	 *  
	 * @param args
	 *		  Array de tipo <code>String</code> con los parametros insertando al ejecutar la aplicación.
	 */
	public static void main(String[] args) {
		// menu
		StringBuilder menu = new StringBuilder("Pragrama que realiza operciones sobre numeros:");
		menu.append("\n\t-Operación 1 (a*b/c).");
		menu.append("\n\t-Operación 2 (a*c)%b.");
		menu.append("\n\t-Operación 3 2*(a+c-b)/(b*c).");
		menu.append("\n\t-Operación 4 ((a*c)+(b%a))/a-c.");
		menu.append("\nInserte una opción (0 para salir): ");
		
		System.out.println("--------------\nOperacioen con enteros.\n--------------");
		operacioensConEnteros(menu.toString());
		
		System.out.println("--------------\nOperacioen con racionales.\n--------------");
		operacioensConRacionales(menu.toString());
	}

	/**
	  * Este método captura tres datos de tipo <code>Integer</code>
	  * y realiza 4 operaciones a elegir por el usuario, mostrando el resutlado por pantalla
	  * 
	  * @param msgMenu
	  *        <code>String</code> con las opciones de las operaciones matemacias
	  *        
	  * {@link #catchNum(String)}
	  */
	public static void operacioensConEnteros(String msgMenu) {
		byte option = 0;
		Integer a, b, c, answer = null;

		// obtenemos los parametors utilizados para los calculos
		a = catchNum("Inserte el valor de a:").intValue();
		b = catchNum("Inserte el valor de b:").intValue();
		c = catchNum("Inserte el valor de c:").intValue();
		
		do {
			// obtenemos la operacion a realizar
			option = catchNum(msgMenu).byteValue();
			switch (option) {
			case 1:
				// Operación 1 (a*b/c)
				if (c != 0) {
					answer = a * b / c;
				} else {
					System.err.println("No se puede dividir por 0.");
					answer = null;
				}
				break;
			case 2:
				// Operación 2 (a*c)%b.
				if (c != 0) {
					answer = (a * b) % c;
				} else {
					System.err.println("No se puede dividir por 0.");
					answer = null;
				}
				break;
			case 3:
				// Operación 3 2*(a+c-b)/(b*c)
				if ((b * c) != 0) {
					answer = 2 * (a + c - b) / (b * c);
				} else {
					System.err.println("No se puede dividir por 0.");
					answer = null;
				}
				break;
			case 4:
				// Operación 4 ((a*c)+(b%a))/a-c
				if ((b * c) != 0) {
					answer = ((a*c)+(b%a))/a-c;
				} else {
					System.err.println("No se puede dividir por 0.");
					answer = null;
				}
				break;
			case 0:
				System.out.println("Adios! Gracias.");
				break;
			}
			if (option >= 1 && option <= 4) {
				System.out.println("El reltado de la operación es " + answer);
			}
		} while (option != 0);

	}

	/**
	  * Este método captura tres datos de tipo <code>Double</code>
	  * y realiza 4 operaciones a elegir por el usuario, mostrando el resutlado por pantalla
	  * 
	  * @param msgMenu
	  *        <code>String</code> con las opciones de las operaciones matemacias
	  *        
	  * {@link #catchNum(String)}
	  */
	public static void operacioensConRacionales(String msgMenu) {
		byte option = 0;
		Double a, b, c, answer = null;

		// obtenemos los parametors utilizados para los calculos
		a = catchNum("Inserte el valor de a:");
		b = catchNum("Inserte el valor de b:");
		c = catchNum("Inserte el valor de c:");
		
		do {
			
			// obtenemos la operacion a realizar
			option = catchNum(msgMenu).byteValue();
			switch (option) {
			case 1:
				// Operación 1 (a*b/c)
				if (c != 0) {
					answer = a * b / c;
				} else {
					System.err.println("No se puede dividir por 0.");
					answer = null;
				}
				break;
			case 2:
				// Operación 2 (a*c)%b.
				if (c != 0) {
					answer = (a * b) % c;
				} else {
					System.err.println("No se puede dividir por 0.");
					answer = null;
				}
				break;
			case 3:
				// Operación 3 2*(a+c-b)/(b*c)
				if ((b * c) != 0) {
					answer = 2 * (a + c - b) / (b * c);
				} else {
					System.err.println("No se puede dividir por 0.");
					answer = null;
				}
				break;
			case 4:
				// Operación 4 ((a*c)+(b%a))/a-c
				if ((b * c) != 0) {
					answer = ((a*c)+(b%a))/a-c;
				} else {
					System.err.println("No se puede dividir por 0.");
					answer = null;
				}
				break;
			case 0:
				System.out.println("Adios! Gracias.");
				break;
			}
			if (option >= 1 && option <= 4) {
				System.out.println("El reltado de la operación es " + answer);
			}
		} while (option != 0);

	}
	
	/**
	  * Este método muestra por pantalla un mensaje y caputra un numero de tipo <code>Double</code>
	  * 
	  * @param msg
	  * 	   mensaje a mostrar por pantalla
	  * 
	  * @return num
	  * 		numero racional de tipo <code>Double</code> introducido por el usuario
	  *        
	  * {@link #catchNum(String)}
	  */
	public static Double catchNum(String msg) {
		Double num = null;
		Scanner sc = new Scanner(System.in);
		byte n = -1;

		do {
			try {
				System.out.print(msg);
				num = sc.nextDouble();
				n = 0;
			} catch (Exception e) {
				System.err.println("Insert a number: " + e);
				n = -1;
				sc.next();
			}
		} while (n == -1);

		return num;
	}
}
