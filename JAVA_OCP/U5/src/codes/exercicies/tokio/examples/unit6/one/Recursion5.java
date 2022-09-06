package codes.exercicies.tokio.examples.unit6.one;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Buscar un elemento de un array de forma recursiva.
 * 
 * @author andre
 *
 *         https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-de-recursividad-java/
 */
public class Recursion5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Inserte el numero a buscar: ");
		// int n,array[] = {0,1,2,3,4,5,6,7,8,9};
		int n, array[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		// Secuencial
		System.out.print("array = { ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
		System.out.println(" }");
		System.out.println("Elemento n= " + n + " en la posicon " + searchOne(array, 0, n));

		// Oredenar de menor a mayor
		shordAa(array, 0, 1);
		System.out.print("array = { ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
		System.out.println(" }");

		// Binaria
		// System.out.println("Elemento n= " + n + " en la posicon " +
		// binarySearch(array, n)); // indica true/false
		short pos = binarySearch2(array, n);
		if(pos<0) {
			System.out.println("Elemento n= "+n+", no encontrado.");
		}else {
			System.out.println("Elemento n= " + n + " en la posicon " + pos
			+ ", array= " + array[pos]);
		}
		
	}

	/**
	 * busqueda secuencial
	 * 
	 * @param array  Array de elementos
	 * @param indice Posicion de la memoria
	 * @param n      Elemento
	 * @return posicion del elemenot, -1 si no lo encuentra
	 */
	static int searchOne(int array[], int indice, int n) {
		int r;
		if (indice >= array.length)
			return -1;
		else {
			if (array[indice] == n)
				return indice;
			else {
				r = searchOne(array, indice + 1, n);
			}
		}
		return r;
	}

	/**
	 * busqueda binaria condicion: array ordenado
	 * 
	 * @param array  Array de elementos
	 * @param indice Posicion de la memoria
	 * @param n      Elemento
	 * @return posicion del elemenot, -1 si no lo encuentra
	 */
	public static boolean binarySearch(int[] numbers, int numberToSearch) {

		int size = numbers.length; // Número de elementos
		int middle = size / 2; // Mitad del array

		System.out.println("Size: " + size);
		System.out.println("Middle: " + middle);
		System.out.println("Array: " + Arrays.toString(numbers));

		if (numbers[middle] == numberToSearch)
			return true;
		else if (size == 1)
			return false;
		else if (numbers[middle] > numberToSearch)
			return binarySearch(Arrays.copyOfRange(numbers, 0, middle), numberToSearch);
		else
			return binarySearch(Arrays.copyOfRange(numbers, middle + 1, size), numberToSearch);
	}

	public static short binarySearch2(int[] numbers, int numberToSearch) {
		return (short) (binarySearch2(numbers, numberToSearch, 0, numbers.length-1));
	}

	public static short binarySearch2(int[] numbers, int numberToSearch, int limitLow, int limitHigh) {
		int middleIn =(short) ((limitLow+limitHigh)/2);
		//System.out.println("limitLow= "+limitLow+", limitHigh "+limitHigh+", middleIn: "+middleIn);
		if(middleIn<0 || numberToSearch<numbers[limitLow]||numberToSearch>numbers[limitHigh]) {
			//System.out.println("Fuera de rango");
			return -1;
		}else{
			if(numberToSearch==numbers[middleIn]) {
				//System.out.println("Bingo!!");
				return (short) middleIn;
			}else {
				if(numberToSearch>numbers[middleIn]) {
					//System.out.println("Desplazamiento a la derecha!! ");
					return binarySearch2(numbers,numberToSearch,middleIn+1,limitHigh);
				}else if(numberToSearch<numbers[middleIn]) {
					//System.out.println("Desplazamiento a la izquierda!! ");
					return binarySearch2(numbers,numberToSearch,limitLow,middleIn-1);
				}
			}
		}
		
		//
		return -1;
	}

	/**
	 * Ordena de menor a mayor recursivo los elementos de un array
	 * 
	 * @param array
	 * @param iter1 Posicon del elemento a
	 * @param iter2 Posicon del elemento siguiente
	 */
	static void shordAa(int array[], int iter1, int iter2) {
		if (iter1 <= array.length - 1) {
			if (iter2 <= array.length - 1) {
				if (array[iter1] < array[iter2]) {
					array[iter1] = array[iter1] + array[iter2];
					array[iter2] = array[iter1] - array[iter2];
					array[iter1] = array[iter1] - array[iter2];
				}
				shordAa(array, iter1, iter2 + 1);
				return;
			} else {
				shordAa(array, iter1 + 1, 0);
				return;
			}
		}
		return;
	}

}
