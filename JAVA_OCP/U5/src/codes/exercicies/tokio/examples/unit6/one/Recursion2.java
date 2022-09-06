package codes.exercicies.tokio.examples.unit6.one;

import java.util.Scanner;

/**
 * Sumar los números números naturales hasta N (se lo damos nosotros) de forma recursiva.
 *
 * @author andre
 *
 */
public class Recursion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Inserte un numero ");
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println("Suman natural hasta "+n+" = "+operation(n));
	}

	static int operation(int n) {
		int r = n;
		if(n==0) return 0;
		else if(n>0) r= r +operation(n-1) ;
		return r;
	}
}
