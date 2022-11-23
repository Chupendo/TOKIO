package exception;

import java.util.function.Function;

// Try anidado
public class ExcDemo5 {
	public static void main(String[] args) {
		int [] number = new int[] {4, 8, 16, 32, 64, 128, 256, 512};
		int [] denom = new int[] {2, 0, 4, 4, 0, 8};
		try {//try externo
			for(int i=0;i<number.length;i++) {
				try {//try anidado
					System.out.println(number[i]+ " / " + denom[i] + " is " + number[i]/denom[i]);
				}catch (ArithmeticException e) {
					// capturar la excepción
					System.out.println("Can't divide by Zero!");
				}	
			}
						
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.err.println("Fatal error -- rogam terminated.");
		}
	}
}