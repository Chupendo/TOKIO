package codes.practises.m3.p4;

/**
 * Al igual que se hizo con la Práctica 1 de conversión de pesos, en este caso se pide crear un programa que imprima una tabla de conversión de pulgadas a metros. Requisitos:
 * 1. Un metros son 39,37 pulgadas
 * 2. Elaborar el programa desde la pulgada 1 hasta la 144
 * 3. La tabla debe de dejar un espacio libre cada 12 pulgadas para ser más legible.
 * 
 * @author Andres Ruiz Penuela
 * @version 1.0.0
 */
public class M1_06_Andres_Ruiz_Penuela {
	public static final double MetterToInch = 39.37;
	
	public static void main(String[] args) {
		
		for(int i=0;i<144;i++) {
			if(i%12==0)
				System.out.println("");
			System.out.printf("%d metro = %.2f pulgadas.\n",i,(i*MetterToInch));
		}
	}
}
