package exception;


// Volver a gnerar una excpeción
public class ExcDemo7 {
	public static void main(String[] args) {
		try {
			Retrhow.genException();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.err.println("Fatal error -- program terminated.");
		}
		System.out.println("After throw");
	}
}

class Retrhow{
	public static void genException() {
		//aquí, number es mayor que denom
		int [] number = new int[] {4, 8, 16, 32, 64, 128, 256, 512};
		int [] denom = new int[] {2, 0, 4, 4, 0, 8};
		
		for(int i=0; i<number.length; i++) {
			try {
				System.out.println(number[i]+ " / " + denom[i] + " is " + number[i]/denom[i]);
			} catch (ArithmeticException e) {
				// capturar la excepción
				System.err.println("Can't divide by Zero!");
			} catch (ArrayIndexOutOfBoundsException e) {
				// caturar la excepción
				System.err.println("No matching element found! ");
				throw e; //Volver a generar la excepcion
			}
			
		}
	}
}
