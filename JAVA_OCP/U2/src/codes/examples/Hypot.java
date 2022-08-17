package codes.examples;

/**
 * Usar el teorema de pitágoras para calcualr la longitud de la hipotenusa desde
 * la longitudes de los dos lados opuestos.
 * 
 * 
 * Nombre del ficheor: Hypot.java
 * 
 * @author AndrÃ©s Ruiz PeÃ±uela
 * @version 1.0.0
 *
 */
public class Hypot {

	public static void main(String[] args) {
		double x, y, z;

		x = 3;
		y = 4;

		z = Math.sqrt(x * x + y * y);// sqrt es un método estatico de la librería Math disponible en la API de Java
		
		System.out.println("Hypotenuse is "+z);
	}
}
