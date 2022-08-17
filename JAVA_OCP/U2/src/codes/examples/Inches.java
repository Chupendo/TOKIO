package codes.examples;

/**
 * Calcula el n�mero de pulgadas c�bicas en una milla c�bica.
 * 
 * 
 * Nombre del ficheor: Inches.java
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0.0
 *
 */
public class Inches {

	public static void main(String[] args) {
		long ci;
		long im;

		im = 5280 * 12;

		// este valor no se puede guardar en un int, short o byte
		ci = im * im * im; // 254358061056000					

		System.out.println("There are " + ci + " cubic inches in cubic miles.");

	}

}
