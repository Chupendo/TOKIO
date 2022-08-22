package codes.practises.m3.p1;

import java.util.Scanner;

import codes.practises.m3.p1.Constantes.ASIGNATURA;
import codes.practises.m3.p1.Constantes.NOTA;

/**
 * Crear un programa que indique al usuario la nota media global de su curso. Requisitos:
 *  1.	El programa pedirá al usuario que introduzca 5 notas, para las asignaturas: Matemáticas, Física, Química, Lenguaje e Historia.
 *	2.	El programa realizará la media de esas cinco notas.
 *  3.	El programa indicará al usuario el rango al que equivale la nota final que ha sacado:
 *		•	Entre 0 –3 Muy deficiente
 *		•	Entre 3 –5 Insuficiente
 * 		•	Entre 5 –6 Suficiente
 *		•	Entre 6 –7 Bien
 *		•	Entre 7 –9 Notable
 *		•	Entre 9 –10 Sobresaliente
 *
 * @author Andres Ruiz Peñuela
 * @version 1.0.0
 *
 */
public class M1_03_Andres_Ruiz_Pneuela {
	
	/**
	 * Metodo principal de la aplicacion
	 * 
	 * @param args
	 * 		  Array de String con los parametros de entrada al lanzar la apliccion
	 */
	public static void main(String[] args) {
		// Declarcion de variables
		Nota notasCurso22;
		String menuAsignturas;
		ASIGNATURA asignatura;
		short opcion, numeroAsignaturas;
		double calificiacion;

		// Inicializacion de variables
		notasCurso22 = new Nota();
		menuAsignturas = ASIGNATURA.getMenuAsignaturas();
		numeroAsignaturas = ASIGNATURA.numeroAsignaturas();

		
		do {
			// Solicitud de asignautras 
			opcion = (short) capturarInt(menuAsignturas);
			if (opcion < 0 || opcion > numeroAsignaturas) {
				System.err.println("Opcion de asignautra no valido");
				continue;
			} else {
				if (opcion != 0) {
					// Obtenemos la asignautra introducida por el usuario
					asignatura = ASIGNATURA.getAsignatura(opcion);

					do {
						// Solicitud de la calificacion
						calificiacion = capturarDouble("Inserte una nota entre 0 y 10: ");
						if (calificiacion < 0 || calificiacion > 10) {
							System.err.println("Valor de nota no valido.");
							continue;
						} else {
							// Calificacion valida
							break;
						}
					} while (true);
					
					// Guardamos la nota
					notasCurso22.addNota(asignatura, calificiacion);
				} else {
					
					// Mostramos las notas y la media
					System.out.println("Adios! Lista de notas: ");
					System.out.println( notasCurso22.toString());
					System.out.println("Su media es: "+notasCurso22.getMedia());
					break;
				}

			}
		} while (true);

	}

	
	/**
	 * Metodo que dado un mensaje devuelve un String introducido por el usuario
	 * 
	 * @param msg
	 * 		  Mensaje de tipo String introducido por el usuario
	 * @return resultado
	 * 		  int introducido por el usuario
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
	 * @param msg
	 * 		  Mensaje de tipo String introducido por el usuario
	 * @return resultado
	 * 		  String introducido por el usuario
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
	 * Metodo que dado un mensaje devuelve un double introducido por el usuario
	 * 
	 * @param msg
	 * 		  Mensaje de tipo String introducido por el usuario
	 * @return resultado
	 * 		  double introducido por el usuario
	 */
	public static double capturarDouble(String msg) {
		double resultado = 0;
		while (true) {
			try {
				resultado = Double.parseDouble(capturarString(msg));
				break;
			} catch (NumberFormatException ex) {
				System.err.println("No es un numero: " + ex);
				continue;
			}
		}
		return resultado;
	}
}
