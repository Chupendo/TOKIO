package lambda_6;

import java.util.function.IntPredicate;

// Metodo que tiente una interfaz funcional como tipo
public class MethodRefDemo {
	public static boolean numTest(IntPredicate p, int v) {
		return p.test(v);
	}
	
	// Metodos estaticos que comprubea un entero con una condicion
	// Ejemplo de predicados

	//Metodo estatico que deuvle si es primo o no
	public static boolean isPrimo(int n) {
		if(n<2) return false;
		for(int i=2; i <= n/i; i++) {
			if((n%i) == 0) {
				return false;
			}
		}
		return true;
	}
	
	// Metodo que de indica si es par o no
	public static boolean isPar(int n) {
		return (n % 2) == 0;
	}
	
	// Meotod que indica si es positiov o no 
	public static boolean isPositive(int n) {
		return n>0;
	}
}
