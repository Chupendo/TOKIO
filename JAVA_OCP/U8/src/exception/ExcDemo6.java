package exception;

import java.util.function.Function;

// Lanzar una excepción
public class ExcDemo6 {
	public static void main(String[] args) {
		try {
			System.out.println("Before throw.");
			throw new ArithmeticException("Error");
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		System.out.println("After throw");
	}
}
