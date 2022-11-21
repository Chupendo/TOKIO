package exception;

// Ejemplo que no contora/captura una excepcion
// La MVJ controla el error con su manejador de excepcioens predetrmiando
public class ExampleExceptionMVJ {

	public static void main(String[] args) {
		int nums[] = new int[] {1,2,3,4};
		
		System.out.println("Before excetion is generated.");
		
		//generar una excepción de índice que supera los límites
		nums[7] = 10;
	}
}
