package exception;

/**
 * 
 * @author andre
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		System.out.println("Empiezo");
		try {
			ejemploThrows();
		}catch (NullPointerException e) {
			System.err.println("Manejo en caso de excepci�n: "+e);
		}
		System.out.println("Continuo");
	}
	
	public static void ejemploThrows() throws NullPointerException {
		//Lanza una excepci�n de forma intencionada
		throw new NullPointerException("Error intencionado");
	}
}
