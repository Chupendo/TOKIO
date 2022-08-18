package codes.exercicies;

import java.util.Scanner;

// Realiza un programa que muestre el fragmento de la cadena de texto a partir de la
// posición de una palabra determinada
// (ambas cadenas introducidas por el usuario)
public class FragmentoString {

	public static void main(String[] args) {
		String phrase;
		short pos;
		
		phrase = catchStr("Inserte una frase: ");
		do {
			pos = catchNum("Inserte la posicion: ");
		}while(pos<0||pos>=phrase.length());
		
		System.out.println("Frase desde la pos= "+pos+" >>"+phrase.substring(pos)+".");
	}
	public static String catchStr(String msg) {
		String text = "";
		Scanner sc = new Scanner(System.in);

		System.out.print(msg);
		text = sc.nextLine();

		return text;
	}
	
	public static short catchNum(String msg) {
		short num = 0;
		Scanner sc = new Scanner(System.in);
		byte n = 1;

		do {
			try {
				System.out.print(msg);
				num = sc.nextShort();
				n = 0;
			} catch (Exception e) {
				System.err.println("Insert a number: " + e);
				n = 1;
				sc.next();
			}
		} while (n == 1);

		return num;
	}
}
