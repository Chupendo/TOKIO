package codes.examples;

// Ilustra los operadores de cortocircuito
public class SCops {

	public static void main(String[] args) {
		int n, d, q;
		
		n = 10;
		d = 2;
		if( d != 0 && (n%d)==0) {
			System.out.println(d + " is factor of "+n);
		}
		
		d= 0; // establcer a cero
		if( d != 0 && (n%d)==0) { //el operador de cortocircutio evita la divisón por cero
			System.out.println(d + " is factor of "+n);
		}
		
		/* Intentar lo mismo sin el operador de cortocircuito.
		 * Se produce un error de división por cero.
		 */
		if( d != 0 & (n%d)==0) { //el operador de cortocircutio evita la divisón por cero
			System.out.println(d + " is factor of "+n);
		}
	}

}
