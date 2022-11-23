package exception;

import java.util.function.Function;

// Usar varias instrucciones catch
public class ExcDemo4 {
	private static Function<Integer, Integer> fun1 = (a) -> (int) Math.round(Math.pow(a, 2));
	public static void main(String[] args) {
		int number[] = new int[8];
		int denom[] = {2,0,4,4,0,8};//new int[number.length];
		for(int i=0;i<number.length;i++) {
			if(i==0)
				number[i] = fun1.apply(2);
			else
				number[i] = fun1.apply(number[i-1]);
		}
		
		// Division number/denom
		for (int i=0; i<number.length; i++) {
			try {
				System.out.println(number[i] + " / " + denom[i] +" is "+number[i]/denom[i]);
			}catch(ArithmeticException exc) {
				// capturar la excepcion
				System.out.println("Can't divide by Zero!");
			}catch(ArrayIndexOutOfBoundsException exc) {
				// capturar la excepcion
				System.out.println("No matching element found.");
			}
		}
	}
}
