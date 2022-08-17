package a4.m2;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Pedir el lado de un cuadrado y calcular su área (a=lado al cuadrado).
 * @author Andrés Ruiz Peñuela
 * @version 1.0.0
 * 
 */
public class M2A4 {

	public static void main(String[] args) {
		//Declaracion de variables
		Double a=0.0,area;
		Scanner sc = new Scanner(System.in);
		char continuar = 'n';
		
		//Pedir lado por consola
		do {
			try {
				System.out.print("Inserte el lado del cuadrado: ");
				a = sc.nextDouble();
				continuar='y';
			}catch(NoSuchElementException | IllegalStateException ex ) {
				System.err.println("No es un numero - "+ex);
				continuar='n';
				sc.nextLine();//Limpiar el buffer de entradas
			}
		}while(continuar!='y');
		
		//Calcuar el area
		area=Math.pow(a,2); //Funcion de "potencias" de la liberari Math  
		
		//Mostrar resultado
		System.out.println("Area del cuadrado: a*a=a^2="+a+"^2="+area+" m^2");
	}

}
