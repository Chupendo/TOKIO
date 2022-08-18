package codes.exercicies;

import java.util.Scanner;

// Realiza un programa que calcule el área de un triángulo (areaTriangulo=base * altura/2)
public class AreaTriangulo {

	public static void main(String[] args) {
		double areaTriangulo,base,altura;
		
		base = catchNum("Inserte la base del tirangulo: ");
		altura = catchNum("Inserte la altura del tirangulo: ");
		areaTriangulo = (base*altura)/2;
		System.out.println("Area del triangulo de base="+base+", y altura= "+altura+", es de "+areaTriangulo);
	}
	
	public static double catchNum(String msg) {
		double num = 0;
		Scanner sc = new Scanner(System.in);
		byte n = 1;

		do {
			try {
				System.out.print(msg);
				num = sc.nextDouble();
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
