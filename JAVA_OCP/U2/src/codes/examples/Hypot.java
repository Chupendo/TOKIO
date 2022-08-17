package codes.examples;

/**
 * Usar el teorema de pit�goras para calcualr la longitud de la hipotenusa desde
 * la longitudes de los dos lados opuestos.
 * 
 * 
 * Nombre del ficheor: Hypot.java
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0.0
 *
 */
public class Hypot {

	public static void main(String[] args) {
		double x, y, z;

		x = 3;
		y = 4;

		z = Math.sqrt(x * x + y * y);// sqrt es un m�todo estatico de la librer�a Math disponible en la API de Java
		
		System.out.println("Hypotenuse is "+z);
	}
}
