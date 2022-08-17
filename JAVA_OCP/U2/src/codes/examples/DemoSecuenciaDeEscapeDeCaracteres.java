package codes.examples;
// Ejemplo de uso de secuencias de escapes de caracteresS
public class DemoSecuenciaDeEscapeDeCaracteres {

	public static void main(String[] args) {
		System.out.println("Retorno de caro: \r \\r.");
		System.out.println("Nueva liena: \n \\n.");
		
		System.out.println("Comilla simple: \' \\'.");
		System.out.println("Comilla doble: \" \\\".");
		
		System.out.println("Tabulación horizontal: \t \\t.");
		
		System.out.println("Salto de formulario: \f \\f");
		
		System.out.println("Retroceso: \b \\b");
		
		char oct = '\100'; //secuencia de escapqe de caracter especial
		System.out.println("Constante octal: "+oct);
		System.out.println("Constante hexadecimal: "+'\u0061');
	}

}
