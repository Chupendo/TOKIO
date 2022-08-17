package codes.exercicies;

/**
 * Convierte Galones en litros
 * Nota: 1 galon son 3.7854 Litros
 * 
 * Nombre del ficheor: GalToLit.java
 * 
 * @author Andr�s Ruiz Pe�uela
 * @version 1.0.0
 *
 */
public class GalToLit {

	public static void main(String[] args) {
		double gallons; // contiene el numero de galones
		double liters; // contiente la conversion a litors
		final double GTOL= 3.7454; // constante que contine el valor de 1 galon en litros
		
		gallons = 10; // se sainga el valor de 10 galones
		liters = gallons * GTOL; // realiza la conversi�n de 10 galones
		
		System.out.println(gallons +" gallons are: "+liters+" liters.");
	}
}