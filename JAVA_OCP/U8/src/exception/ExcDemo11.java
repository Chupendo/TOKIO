package exception;

import java.io.IOException;

// Ejemplo captura múltiple
public class ExcDemo11 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };

		for (int i = 0; i <= a.length; i++) {
			try {
				System.out.print(a[i] + "/" + i + "= ");
				System.out.println(a[i] / i);
			} catch (ArithmeticException 
					| IndexOutOfBoundsException e) {
				//e = null; // el objeto e es final
				System.out.println("Excepction: " + e);
			}
		}
		System.out.println("End preseed.");
	}
}
