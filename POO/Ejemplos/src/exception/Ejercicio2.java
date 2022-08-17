package exception;

/**
 *
 * @author andre
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		System.out.println("Empiezo");
		ejemploThrows();
		System.out.println("Continuo");
	}
	
	public static void ejemploThrows() throws NullPointerException{
		//Lanza una excepción de forma intencionada
		throw new NullPointerException("Error intencionado");
	}
}
