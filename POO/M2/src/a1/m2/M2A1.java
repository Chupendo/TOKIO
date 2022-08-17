package a1.m2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Realizamos un programa Java que calcule la media aritmética de los 6 números que introduzcamos con el teclado.
 * @author Andrés Ruiz Peñuela
 * @version 1.0.0
 *
 */
public class M2A1 {
	static final int  N=6; //Numero de elementos
	
	public static void main(String[] args) {
		//Definición e Inicialización de variables
		char attempt='n';
		int number=0,sum=0;
		Scanner sc = new Scanner(System.in);
		
		//Caputra de los elementos con control de excepción
		for(int i=0;i<N;i++) {
			do {
				try {
					System.out.print("Inserte un numero (step "+(i+1)+"): ");
					number = sc.nextInt();//Captura & casting del elemento
					sum+=number;//Suma de elementos
					attempt='n';
				}catch (InputMismatchException e) {
					System.err.println("\t\sNo es un numero.");
					sc.next(); //Permite limpiar el buffer de entrada
					attempt='y';
				}
			}while(attempt=='y');
		}//fin for
		
		//Media aritmetica & visualiacion por pantalla el resultado
		System.out.println("Suma de los numeros introducidos: "+sum+", Media aritmectica: "+(double)sum/N);
	}
}
