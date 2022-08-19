package codes.examples;

import java.io.IOException;

// Juego de adivinar letras
public class Guess2 {

	public static void main(String[] args) throws IOException {
		char ch, answer = 'K';
		System.out.println("I'm thinking of a letter between A and Z.");
		System.out.print("Can you guess it: ");
		ch = (char) System.in.read(); // obtener read
		
		if(ch==answer) System.out.println("+++ Right +++");
	}

}
