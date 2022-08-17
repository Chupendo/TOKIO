package codes.examples;

// Las variables de caracteres se pueden procesar como enteros
public class CharArithDemo {

	public static void main(String[] args) {
		char ch;
		
		ch = 'X';
		System.out.println("ch contains "+ch);
		
		ch++; //increment an unit (next digit)
		System.out.println("ch is now "+ch);
		
		ch=90; //the code ASCII of 'Z' is 90 (char UNICAODE of 16bit -> ASCII is subcode of UNICODE fo 8bit)
		System.out.println("ch is now "+ch);
	}

}
