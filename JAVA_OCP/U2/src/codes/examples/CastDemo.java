package codes.examples;


// Ilustra la conversión explicita: Casting
public class CastDemo {

	public static void main(String[] args) {
		double x,y;
		byte b;
		int i;
		char ch;
		
		x = 10.0;
		y = 3.0;
		
		i = (int) (x / y); // convierte double a int. Se produce recorte
		System.out.println("Integer outcome of x / y: "+ i);
		
		i = 100;
		b = (byte) i; // no se pierde informaicón. byte puede almacenar el valor 100.
		System.out.println("Value of b: "+b);
		
		i = 257;
		b = (byte) i; // se pierde informaicón. byte no puede almacenar el valor 257.
		System.out.println("Value of b: "+b);
		
		b = 88; // código ASCCI para X
		ch = (char) b; // conversión entre tipos incompatibles
		System.out.println("ch: "+ch);

	}

}
