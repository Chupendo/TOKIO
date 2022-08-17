package codes.exercicies;

/**
 * Calcula el peso de Luna
 * Nota: 
 *  - Gravedad de la tierra 9,807 m/s²
 *  - Gravedad de la luna 17% de la graved de la tierra
 *  
 *  g=(G*MT)/R^2 donde:
 *   - g es la Gravedad
 *   - G constante de la gravitación universal  G≈6,674×10^−11 N⋅m^2⋅kg^−2
 *	 - MT masa de la tierra = 6⋅10^24  kg
 *	 - R radio de la tierra = 6371  km.
 * 
 * 	 - Gravedad de la luna: 1,62 m/s²
 *   - Radio de la luna: 1.737,4 km
 *   
 * Nombre del ficheor: WeigthMoon.java
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0.0
 *
 */
public class WeigthMoon {

	public static void main(String[] args) {
		final double G=6.674/Math.pow(10, 24),gMoon = 1.62/Math.pow(10, 11),RMoon=1737.4, MMoon;
		
		MMoon = (Math.pow(RMoon, 2)*gMoon)/G;
		System.out.println("La masa de la Luna es: "+MMoon+" kg.");
	}
}
