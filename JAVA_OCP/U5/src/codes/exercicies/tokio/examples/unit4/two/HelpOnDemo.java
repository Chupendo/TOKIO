package codes.exercicies.tokio.examples.unit4.two;

import java.util.Scanner;

public class HelpOnDemo {

	public static void main(String[] args) {
		Help help = new Help();
		Scanner sc = new Scanner(System.in);
		char ch;
		
		while(true) {
			do {
				help.showMenu();
				ch = sc.next().charAt(0);
			}while(help.isValid(ch));
			
			if(ch=='q') break;
			
			help.helpOn(ch);
		}

	}

}
