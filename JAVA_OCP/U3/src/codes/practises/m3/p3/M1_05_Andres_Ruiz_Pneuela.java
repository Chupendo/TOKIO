package codes.practises.m3.p3;

import java.util.Scanner;

/**
 * Desarrollar un programa que determine si un número es un número de Amstrong.
 * 
 * Un número de Amstronges aquel que es igual a la suma de sus dígitos elevados
 * a la potencia de su número de cifras. 
 * 
 * Por ejemplo, el número 371 es un número que cumple dicha característica ya que tiene 3 cifras y:
 *  371 = 3^3+ 7^3+ 1^3= 37 + 343 + 1 = 371 
 *  
 * Recursos para el ejercicio: 
 * 	• Math.floorDevuelve el máximo entero menor o igual a un número pasado como parámetro. 
 * 	• Math.log10 Devuelve el logaritmo en base 10 de un número pasado como parámetro. 
 * 	• Math.powDevuelve el valor del primer argumento elevado a la potencia delsegundo argumento.
 * 
 * @version 1.0.0
 * @author Andres Ruiz Penuela
 */

public class M1_05_Andres_Ruiz_Pneuela {

	public static void main(String[] args) {
		int numero;

		numero = capturarInt("Inserte un numero entero: ");
		System.out.println("Es Amstrong: " + isAmstrong(numero));
	}

	/**
	 * Metodo que dado un mensaje devuelve un String introducido por el usuario
	 * 
	 * @param msg Mensaje de tipo String introducido por el usuario
	 * @return resultado int introducido por el usuario
	 */
	public static String capturarString(String msg) {
		Scanner sc = new Scanner(System.in);
		String resultado;

		System.out.print(msg);
		resultado = sc.nextLine();

		return resultado;
	}

	/**
	 * Metodo que dado un mensaje devuelve un integer introducido por el usuario
	 * 
	 * @param msg Mensaje de tipo String introducido por el usuario
	 * @return resultado String introducido por el usuario
	 */
	public static int capturarInt(String msg) {
		int resultado = 0;
		while (true) {
			try {
				resultado = Integer.parseInt(capturarString(msg));
				break;
			} catch (NumberFormatException ex) {
				System.err.println("No es un numero: " + ex);
				continue;
			}
		}
		return resultado;
	}

	/**
	 * Obteiene el numero de digitos de un numero
	 * 
	 * @param numero int numero
	 * @return n short numero de digitos del numero recibido
	 */
	public static short numeroDigitos(int numero) {
		short n = 0;
		do {
			if (numero % 10 > 0) {
				n++;
				numero = numero / 10;
			} else {
				break;
			}
		} while (true);
		return n;
	}

	/**
	 * Metodo que comprueba si el numero es Amstrong
	 * 
	 * @param numero
	 * 		int a comprobar si es Amstrong o no
	 * @return true si el numeor es Amstrong, false en otro caso
	 */
	public static boolean isAmstrong(int numero) {
		int resultado;
		short nDigitos, cociente, resto;

		cociente = (short) (numero / 10);
		resto = (short) (numero % 10);
		resultado = 0;
		nDigitos = numeroDigitos(numero);
		
		for (short i = 0; i < nDigitos; i++) {
			//System.out.println("cociente= "+cociente+", resto= "+resto);
			resultado = (int) (resultado + Math.pow(resto, nDigitos));
			resto = (short) (cociente % 10);
			cociente = (short) (cociente / 10);
		}
		return resultado == numero;
	}
}
