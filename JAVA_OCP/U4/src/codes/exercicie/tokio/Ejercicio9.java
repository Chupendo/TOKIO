package codes.exercicie.tokio;
/**
 * Realiza un programa que calcule si un C�digo de Cuenta Bancaria es v�lido o no.
 * 
 * @author Andres Ruiz Penuela
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {
		String dni = "ES1234567891234567";
		
		if(dni.toUpperCase().matches("ES[0-9]{16}")) {
			System.out.println("Es un cuenta bancaria");
		}else {
			System.err.println("No es un una cuenta bancaria");
		}
	}
}
