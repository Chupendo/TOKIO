package codes.examples;

public class ExampleArrayStringToChar {

	public static void main(String[] args) {
		String cadena = "Hola mundo!";
		char [] arrayChar;
		
		arrayChar = cadena.toCharArray();
		for(char caracter : arrayChar) {
			System.out.println(caracter);
		}
		System.out.println("---------");
		
		String cadena2 = new String(arrayChar);
		System.out.println(cadena2);
	}
}
