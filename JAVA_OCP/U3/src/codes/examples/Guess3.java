package codes.examples;

import java.io.IOException;

// Juego de adivinar letras
public class Guess3 {

	public static void main(String[] args) throws IOException {
		char ch, answer1 = 'K', answer2 = 'k';
		System.out.println("I'm thinking of a letter between A and Z.");
		System.out.print("Can you guess it: ");
		ch = (char) System.in.read(); // obtener read
		
		if(ch==answer1) {
			System.out.println("+++ Right +++");
		}
		else {
			if(ch==answer2) {
				System.out.println("+++ Right +++");
			}else {
				System.out.println("...Sorry, you are wrong.");
			}
		}
	}

}
