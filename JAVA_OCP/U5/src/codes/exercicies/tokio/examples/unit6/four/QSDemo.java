package codes.exercicies.tokio.examples.unit6.four;

import java.util.Arrays;

/**
 * Ejercicio 6.3. Ordenamiento rápido Método inventado por C.A.R. Hoare
 * Catalogado como el mejor algoirtimo gneral de ordenamiento que existe en la
 * actualidad
 * 
 * Consite en coger un punto de comparacion y dividr la matriz en dos, y
 * ordenarla Inical: fedacb, comparacion: d Primera pasada: bcadef
 * 
 * La version implementada, selcciona le elemento central como comparado.
 * 
 * @author andre
 *
 *         Inical: fedacb, length= 5 comparacion: 5/2 = 2 > d 
 *         Primera pasada: bcadef, length= 5 comparacion: 5/2 = 2 > a 
 *         Segunda pasada: acbdef, length= 5 comparacion: 5/2 = 2 > b 
 *         Tercera pasada: abcdef, length= 5 comparacion: 5/2 = 2 > c
 */
public class QSDemo {

	public static void main(String[] args) {
		char[] secuencia = { 'f', 'e', 'd', 'a', 'c', 'b' };
		showData(secuencia);

		QuickSort.quickSort(secuencia);
		showData(secuencia);
	}

	public static void showData(char[]  data) {
		System.out.print("array: {");
		for(int i=0;i<data.length;i++) {
			System.out.print(" "+data[i]);
		}
		System.out.println(" }");
	}
}
