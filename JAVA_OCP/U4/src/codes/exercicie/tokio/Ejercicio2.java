package codes.exercicie.tokio;
import java.util.Scanner;

/**
 * Escribe un programa que solicite 5 notas al usuario y calcule la nota media.
 * 
 * @author Andres Ruiz Penuela
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double nota[] = new double[5], sum=0.0;
		short i=0;
		do {
			if(i==5) break;
			
			System.out.print("Inserte la nota "+(i+1)+": ");
			try {
				nota[i] = sc.nextDouble();
				sum += nota[i];
				i++;
			}catch(Exception ex) {
				System.err.println("No es un numero: "+ex);
				sc.nextLine();
			}
		}while(true);
		
		System.out.println("Media: "+(sum/nota.length));
	}
}