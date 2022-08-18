package codes.exercicies;

import java.util.Scanner;

// Realiza un programa que muestre por pantalla un número aleatorio entre dos valores 
// introducidos por el usuario
public class NumRandom {

	public static void main(String[] args) {
		long a,b,num;
		
		a = catchNum("Inserte el rango inferior: ");
		b = catchNum("Inserte el rango superior: ");
		
		num = (long) ((Math.random()*(b-a*1))+a); //Valores entre a y b includios
		System.out.println("Numero aleatorio entre ["+a+","+b+"]="+num);

	}
	
	public static long catchNum(String msg) {
		long num = 0;
		Scanner sc = new Scanner(System.in);
		byte n = 1;

		do {
			try {
				System.out.print(msg);
				num = sc.nextLong();
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
