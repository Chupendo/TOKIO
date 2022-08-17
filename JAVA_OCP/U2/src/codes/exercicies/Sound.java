package codes.exercicies;

/**
 * �A que distancia est� el rel�mpago?
 * Programa ue calcula la distancia, en pies, de un individuo respecto a un rel�mpago.
 * 
 * Calcuar la distanica de un rel�mpago que se tarde en percibir 7,2"
 * 
 * Nota: El sonido se desplaza a 1.100 pies por segundo
 * 
 * Condici�n: Usar double en lugar de float.
 * Nombre del ficheor: Sound.java
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0.0
 *
 */
public class Sound {

	public static void main(String[] args) {
		double dist;
		
		dist = 7.2 * 1_100;
		
		System.out.println("This lightning is "+ dist +" feet away.");
	}
}
