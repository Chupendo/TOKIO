package codes.examples;

// Demostrar valroes booleanos
public class BoolDemo {

	public static void main(String[] args) {
		boolean b;
		
		b=false;
		System.out.println("b is "+ b);
		b=true;
		System.out.println("b is "+ b);
		
		// un valor booleano puede contorlar la instrucción if
		if(b) System.out.println("This is executed");
		
		b=false;
		if(b) System.out.println("This is not executed");
		
		// el resutlado de una operación racional es un vlaor boolean
		System.out.println("10 > 9 is "+ (10>9));
		

	}

}
