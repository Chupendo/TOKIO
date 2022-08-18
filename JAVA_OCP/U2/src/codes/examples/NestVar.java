package codes.examples;

/*
 * Este programa intenta declarar una variable
 * en un ámbito interno con el mismo nombre que otra
 * definida en un ámbito externo.
 *
 * Este programa no se compila
 */
public class NestVar {

	public static void main(String[] args) {
		int count;
		
		for (count=0;count<10;count = count+1) {
			System.out.println("This is count: "+count);
			
			int count; // ¡Incorrecto! Ya se ha declarado count antes
			for (count=0;count<10;count = count+1) {
				System.out.println("This is count: "+count);
			}
		}
	}
}
