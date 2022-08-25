package codes.practises;
import java.util.Scanner;

/**
 * Dada una cadena, cuenta el número de vocales que existe en la misma.
 * 
 * @version 1.0.0
 * @author Andres Ruiz Penuela
 *
 */
public class M1_09_Andres_Ruiz_Penuela {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String texto; 
		Vocales vocal = new Vocales();
		System.out.println("Vocales de \"AeIoU\": "+vocal.contarVocales("AeIoU"));
		System.out.println("Vocales de \"nacio una abeja bajo el sol“\": "+vocal.contarVocales("nacio una abeja bajo el sol“"));
		System.out.println("Vocales de \"¿Nació una abeja bajo el Sol?“\": "+vocal.contarVocales("¿Nació una abeja bajo el Sol?“"));
		
		do {
			System.out.print("-------------\nInserte una cadena (. para salir): ");
			texto = sc.nextLine();
			if(texto.equals("."))
				break;
			System.out.println("Vocales de \""+texto+"\": "+vocal.contarVocales(texto));
		}while(true);
		
	}
	
	
	static class Vocales{
	
		/**
		 * Dada una cadena, cuenta el número de vocales que existe en la misma.
		 * 
		 * - cuenta las vocales tanto mayúsculas como minúsculas
		 * - no cuenta las consonantes
		 * - Ignora las vocales acentuadas y otros caracteres
		 * 
		 * @param cadena
		 * 			Cadena a analizar
		 * @return count
		 * 			int numero de caracetres
		 */
		public int contarVocales(String cadena) {
			int count = 0;
			for(char caracter : cadena.toLowerCase().toCharArray()) {
				switch(caracter) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					count++;
					break;
				}
			}
			return count;
		}
	}
}
