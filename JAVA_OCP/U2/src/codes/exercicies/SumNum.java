package codes.exercicies;

import java.util.Scanner;

// Realiza un programa en el que el usuario deba introducir dos valores cualesquiera y 
// se le muestre la suma de ambos
public class SumNum {

	public static void main(String[] args) {
		double num1,num2;
			
		num1 = catchNum();
		num2 = catchNum();
		
		System.out.println(num1+" + "+num2+" = "+(num1+num2));

	}
	
	public static double catchNum() {
		double num = 0;
		Scanner sc = new Scanner(System.in);
		byte n = 1;
		
		do {
			try {
				System.out.print("Inserte un numero cualesquiera:");
				num = sc.nextDouble();
				n = 0;
			}catch (Exception e) {
				System.err.println("Insert a number: "+e);
				n = 1;
				sc.next();
			}
		}while(n==1);

		return num;
	}
}
