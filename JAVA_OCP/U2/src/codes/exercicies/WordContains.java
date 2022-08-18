package codes.exercicies;

import java.util.Scanner;

// Realiza un programa que compruebe si un texto aparece en una cadena determinada
//(ambas introducidas por el usuario)
public class WordContains {

	public static void main(String[] args) {
		String phrase, word;
		
		phrase = catchStr("Inserte una frase: ");
		word = catchStr("Inserte la palabra a buscar en la frase: ");
		
		if(phrase.contains(word)) {
			System.out.println(word+" esta "+phrase);
		}else {
			System.out.println(word+" no esta en "+phrase);
		}

	}

	public static String catchStr(String msg) {
		String text = "";
		Scanner sc = new Scanner(System.in);

		System.out.print(msg);
		text = sc.nextLine();

		return text;
	}
}
