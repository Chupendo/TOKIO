package codes.examples;

/*
 * Uso de if
 * Asigen el nombre IfDemo.java a este archivo.
 */
public class IfDemo {

	public static void main(String[] args) {
		int a,b,c;
		
		a=2;
		b=3;
		
		if(a<b) System.out.println("a is less than b");
		
		// no muestra nada
		if(a==b) System.out.println("a is equal than b");
		
		System.out.println();
		
		c = a - b ; // c contiene -1
		
		System.out.println("c containts -1");
		if(c >= 0 ) System.out.println("c is non-negative");
		if(c < 0) System.out.println("c is negative");
		
		System.out.println();
		
		c = b - a; // c contiene 1
		System.out.println("c containts 1");
		if(c >= 0 ) System.out.println("c is non-negative");
		if(c < 0) System.out.println("c is negative");
	}
}
