package codes.exercicie.tokio;

import java.util.Scanner;

/**
 * Escribe un programa a través del cual un usuario pueda jugar al juego del ahorcado.
 * El ordenador se tendrá que pensar una palabra (se puede partir de un diccionario fijo 
 * de palabras y que elija una) y el usuario tendrá que adivinar la proponiendo, por turnos, 
 * caracteres para ir completándola. 
 * 
 * El usuario tendrá número límite de intentos y habrá que tener en cuenta que si el caracter
 * aparece más de una vez en la palabra, habrá que mostrar todos los casos.
 * 
 * @author Andres Ruiz Penuela
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String words[] = { "one", "two", "three", "for" }, wordFound="",word;
		char ch, discover[] = new char[10];
		short attempt = 6, choose = 0, hits = 0, iter = 0;
	
		choose = (short) (Math.round(Math.random() * words.length));
		word=(choose==words.length)?words[choose-1].toLowerCase():words[choose].toLowerCase();
		wordFound = buildWordX(word);
		mostrar(attempt, discover, wordFound);
		
		do {
			
			try {
				System.out.print("Inserte un caracter: ");
				ch = sc.nextLine().toLowerCase().charAt(0);
				discover[iter] = ch;
				iter++;

				char temp[], temp2[] = wordFound.toCharArray();
				if (word.indexOf(ch)!=-1) {
					temp =word.toCharArray();
					for (int i = 0; i < word.length(); i++) {
						if (temp[i] == ch) {
							temp2[i] = ch;
							hits++;
						}else {
							temp2[i] = wordFound.toCharArray()[i];
						}
					}
				}else {
					attempt--;
				}
				wordFound = String.copyValueOf(temp2);
				System.out.println("--------------------------------");
				mostrar(attempt, discover, wordFound);
			
			}catch (Exception e) {
				System.err.println("Inserte un caracter valido: "+e);
				sc.nextLine();
			}

		} while (attempt > 0 && hits != word.length());

	}

	public static void mostrar(short attempt, char[] discover, String wordFound) {
		System.out.println("Intentos restantes: " + attempt);
		

		System.out.print("Caracteres dichos: ");
		for (char elem : discover) {
			System.out.print(elem + " ");
		}
		System.out.println();

		System.out.println("Descubir: "+wordFound);
	}
	
	public static String buildWordX(String word) {
		StringBuilder temp = new StringBuilder();
		for (int x = 0; x < word.length(); x++) {
			temp.append("_");
		}
		return temp.toString();
	}

}
