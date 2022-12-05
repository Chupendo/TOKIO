package exception;


// Utilizar los métodos Throwable
public class ExcDemo8 {
	public static void main(String[] args) {
		try {
			UseThrowableMethods.genException();
		}catch (Exception exc) {
			// capturar la excepción
			System.out.println("Standar message is: ");
			System.out.println(exc);
			System.out.println("\nStack trace: ");
			exc.printStackTrace();
		}
	}
}

class UseThrowableMethods{
	public static void genException() {
		int nums[] = new int[4];
		
		System.out.println("Before exception is generated.");
		
		// generar una excepción de índice que supera los límites
		nums[7] = 10;
		System.out.println("his won't be displayed");
	}
}
