package exercicies.heredity.u6.ejer2.service;

import java.util.Scanner;

public class Input {
	private static final Scanner SC = new Scanner(System.in);
	
	public static String getString(String msg) {
		System.out.print(msg); 
		return SC.nextLine();
	}
	
	public static short getShort(String msg, int min, int max) {
		return (short) getInt(msg, min, max);

	}
	
	public static int getInt(String msg, int min, int max) {
		int number;
		do {
			
			try {
				System.out.println(msg);
				number = SC.nextInt();
				if(number>=min&&number<=max) break;
			}catch (Exception e) {
				System.err.println("Numero no valido");
				SC.next();
				number=-1;
			}
		}while(true);
		return number;
	}
}
