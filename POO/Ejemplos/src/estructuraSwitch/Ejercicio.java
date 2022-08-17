package estructuraSwitch;
/**
 * Dada la frase “Hoy Es Lunes VEintunuevE dE Abril", contar:
 * - El número de vocales.
 * - El número de consonantes.
 * - El número letras que incluye.
 * 
 * Ha de contarse tanto la e minúscula como la E mayúscula.
 * @author andre
 *
 */
public class Ejercicio {

	public static final String PHRASE= "Hoy Es Lunes VEintunuevE dE Abril";
	
	public static void main(String[] args) {
		
		int n_letters = PHRASE.length(), n_vocals=0, n_consonants=0;
		
		for(int i=0;i<n_letters;i++) {
			char letter = PHRASE.toLowerCase().charAt(i); 
			
			switch(letter) {
			case 'a':
				n_vocals++;
				break;
			case 'e':
				n_vocals++;
				break;
			case 'i':
				n_vocals++;
				break;
			case 'o':
				n_vocals++;
				break;
			case 'u':
				n_vocals++;
				break;
			default:
				n_consonants++;;
			}//switch
		}//for
		
		System.out.println("Numero de letras: "+n_letters);
		System.out.println("Numero de vocales: "+n_vocals);
		System.out.println("Numero de consonantes: "+n_consonants);
	}//main
}//class
