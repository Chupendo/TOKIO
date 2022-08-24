package codes.exercicie.tokio;
/**
 * Realiza un programa que calcule si un número de DNI es válido o no.
 * 
 * @author Andres Ruiz Penuela
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {
		String dni = "96895425T";
		
		if(dni.matches("[0-9]{8}[a-zA-Z]{1}")) {
			System.out.println("Es un DNI");
		}else {
			System.err.println("No es un deni");
		}
	}
}
