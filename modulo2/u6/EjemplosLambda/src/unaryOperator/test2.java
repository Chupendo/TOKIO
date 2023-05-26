package unaryOperator;

import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class test2 {

	public static void main(String[] args) {
		int num = 2;
		Integer exp = 3;
		IntUnaryOperator pow = n -> n * n;
		IntBinaryOperator potencia = (a, b) -> {
			int i = 1, r = a;
			while (i < b) {
				r *= a;
				i++;
			}
			return r;
		};
		
		System.out.println("2^2: " + pow.applyAsInt(num));
		// Auto-cast
		int resul =  potencia.applyAsInt(num, exp);
		System.out.println("2^3:" +resul);
	}
}
