package exception;

import java.io.IOException;

// Ejemplo de excepciones encadenadas
public class ExcDemo13 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };

		for (int i = 0; i <= a.length; i++) {
			try {
				System.out.print(a[i] + "/" + i + "= ");
				System.out.println(a[i] / i);
			} catch (ArithmeticException e) {
				//Puede ser por que el pareamtro que se caputra es cero
				e.initCause(new IOException());
				System.out.println("Exception "+e+"Stack: ");
				e.printStackTrace();
			}catch(final IndexOutOfBoundsException e) {
				//e = null; // el objeto e es final
				System.out.println("Excepction: " + e);
			}
		}
		System.out.println("End preseed.");
	}
}
