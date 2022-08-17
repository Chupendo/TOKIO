package a9.m2;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * En esta pr�ctica se va a abordar el manejo de excepciones y la cl�usula
 * finally.
 * 
 * En primer lugar se va a realizar un men� mostrado por consola en el que se
 * pueda elegir: - Opci�n 1. Sumar - Opci�n 2. Restar - Opci�n 3. Multiplicar -
 * Opci�n 4. Dividir
 *
 * Una vez le�da la opci�n (tiene que ser de tipo entero) introducida por el
 * usuario, se va a pedir que introduzca el n�mero a y el n�mero b.
 * 
 * @author Andr�s Ruiz Pe�uela
 * @version 1.0.0
 *
 */
public class M2A9 {

	public static void main(String[] args) {
		// Declaracion de las variables
		StringBuilder menu = new StringBuilder();
		int opcion, a, b;
		Scanner sc;

		// Init de las variables
		menu.append("Indique el numero de la operacion con numeros enteros: ");
		menu.append("\n\t- Opci�n 1. Sumar");
		menu.append("\n\t- Opci�n 2. Restar");
		menu.append("\n\t- Opci�n 3. Multiplicar");
		menu.append("\n\t- Opci�n 4. Dividir");
		menu.append("\n\t- Opci�n 0 para salir:");
		opcion = 0;
		sc = new Scanner(System.in);

		//
		do {
			try {
				//Solicitamos la opci�n a realizar
				System.out.print(menu.toString());
				opcion = sc.nextInt();

				
				if (opcion >= 0 && opcion <= 4) {
					//Si es una operacion, solicitmaos a y b
					System.out.print("Valor de a= ");
					a = sc.nextInt();
					System.out.print("Valor de b= ");
					b = sc.nextInt();
					
					//Realizamos la operaci�n y mostramos por pantalla
					switch (opcion) {
						case 1:
							System.out.println(a + "+" + b + "=" + sumar(a, b));
							break;
						case 2:
							System.out.println(a + "-" + b + "=" + restar(a, b));
							break;
						case 3:
							System.out.println(a + "*" + b + "=" + multiplicar(a, b));
							break;
						case 4:
							System.out.println(a + "/" + b + "=" + dividir(a, b));
							break;
						default:
							System.out.println("Adios!");
							break;
					}
				}
			} catch (NoSuchElementException | IllegalStateException ex) {
				System.err.println("No es un numero - " + ex);
				sc.nextLine();
				opcion = -1;
			}

		} while (opcion != 0);
	}

	/**
	 * Suma de a y b
	 * 
	 * @param a:int
	 * @param b:int
	 * @return int
	 */
	public static int sumar(int a, int b) {
		return a + b;
	}

	/**
	 * Resta de a y b
	 * @param a:int
	 * @param b:int
	 * @return int
	 */
	public static int restar(int a, int b) {
		return a - b;
	}

	/**
	 * Mutiplicacion de a y b
	 * 
	 * @param a:int
	 * @param b:int
	 * @return int
	 */
	public static int multiplicar(int a, int b) {
		return a * b;
	}

	/**
	 * Division de a y b. Devuelve 0 si b=0.
	 * 
	 * @param a:int
	 * @param b:int
	 * @return float
	 * 
	 * @exception ArithmeticException
	 */
	@SuppressWarnings("finally")
	public static float dividir(int a, int b) {
		float resultado = 0;
		try {
			resultado = a /(float)b;
		} catch (ArithmeticException ae) {
			System.err.println("No se puede divider entre 0! "+ae);
			resultado = 0;
		} finally {
			return resultado;
		}
	}

}
