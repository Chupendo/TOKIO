package codes.exercicies;

import java.util.Scanner;

// Realiza un programa que indique cuántos dígitos tiene un número introducido por el usuario
public class NDigitos {

	public static void main(String[] args) {
		long num;
		int count=1;
		
		num = catchNum();
		
		while(num/10!=0) {
			count++;
			num=num/10;
		}
		System.out.println(num+" tienes "+count+" digitos");
		
	}

	public static long catchNum() {
		long num = 0;
		Scanner sc = new Scanner(System.in);
		byte n = 1;

		do {
			try {
				System.out.print("Inserte un numero entero cualesquiera:");
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
