package codes.exercicie.tokio;

/**
 * Escribe un programa que muestre,aleatoriamente,una palabra 
 * (Puedes partir de un diccionario almacenado en un array)
 * 
 * @author Andres Ruiz Penuela
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		String array[] = {"One","Two","Three","For","Five","Six","Seven","Eight","Nine","Then"};

		short numero =(short) Math.round(Math.random()*10);
		if(numero==10) numero--;
		
		System.out.println("Word: "+array[numero]);
	}
}
