package codes.exercicies.tokio.examples.unit6.one;

import java.util.Scanner;

/**
 * Factorial de un número.
 * 
 * @author andre
 *
 */
public class Recursion4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				System.out.print("Inserte un numero: ");
				int n;
				Scanner sc = new Scanner(System.in);
				n = sc.nextInt();
				System.out.println("Factorial de "+n+" = "+fac(n));
	}

	static int fac(int n) {
		int r=n;
		if (n==0) return 1;
		else if(n>0) r = r*fac(n-1);
		return r;
	}
}
