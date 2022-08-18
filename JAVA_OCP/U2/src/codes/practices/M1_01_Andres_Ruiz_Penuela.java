package codes.practices;

import java.util.Scanner;

/**
 * La gravedad de la Luna es aproximadamente el 17% de la gravedad de la Tierra. 
 * Se pide:
 * 	1. Crear un programa que, dado un peso de la Tierra, calcule su equivalente en la Luna.
 *  2. El programa debe mostrar por pantalla un mensaje similar a este: 
 *  		“Un peso de 30 kilos en la Tierra equivalen a X kilos en la Luna”.
 *  
 *  Apuntes: 
 *  El peso de un objeto se define como la fuerza de la gravedad sobre el objeto 
 *  y se puede calcular como el producto de la masa por la aceleración de la gravedad
 *  					w = m*g
 *  
 * @author Andrés Ruiz Peñuela
 * @version v1.0.0
 *
 */
public class M1_01_Andres_Ruiz_Penuela {

	public static void main(String[] args) {
		double m = 30; // Masa del objeto > kg

		// Muestra el resultado
		System.out.println("Un peso de "+m+" kilos en la Tierra equivalen a "+m/1.17+" kilos en la Luna");
	}
}
