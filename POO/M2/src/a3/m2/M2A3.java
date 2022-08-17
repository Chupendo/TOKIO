package a3.m2;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Crear una clase llamada Cuenta que tendrá los atributos Titular, Número de
 * cuenta y Cantidad. Comparar dos cuentas a ver cuál tiene más dinero.
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0.0
 *
 */
public class M2A3 {
	// Creamos un objeto con las operaicones de cuenta
	private static IOperacionesCuenta operaciones = new OperacionesCuenta();

	public static void main(String[] args) {
		// Definición e Inicialización de variables
		Cuenta[] cuentas = new Cuenta[2];
		Cuenta resultado = null;

		// Cargamos las cuentas nuevas
		cuentas[0] = new Cuenta(operaciones.nuevaCuenta());
		cls();// Limpia la consola

		cuentas[1] = new Cuenta(operaciones.nuevaCuenta());
		cls();// Limpia la consola
		//Listar cuentas
		operaciones.verCuentas(cuentas);
		
		// Obtenemos la cuenta
		resultado = operaciones.obetenerCuentaConMasDinero(cuentas[0], cuentas[1]);
		System.out.println("La cuenta con mayor cantidad es: "
				+ ((resultado==null)?"Son iguales":resultado.toString()));

	}

	/**
	 * Funcion generica para limpiar el terminar
	 */
	public static void cls() {
		try {

			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
			System.err.println("No se puede limpiar el terminal: " + ex);
		}
	}
}
