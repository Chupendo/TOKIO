package codes.exercicies.tokio.examples.unit6.four;

public class QuickSort {
	private static void swap(char item[], int left, int right) {
		char aux = item[right];
		item[right] = item[left];
		item[left] = aux;
	}

	public static void quickSort(char[] item) {
		quickSort(item, 0, item.length - 1);
	}

	private static void quickSort(char[] item, int start, int end) {
		int i = start;
		int j = end;
		char pivot = item[(end - start) / 2];

		// Los elementos menores que pivote se envia a la izquierda
		// Los elementos mayores que pivote se eniva a la derecha
		// Los elementos iguales dan lo mismo
		while (i <= j) { // Minetras no se crucen

			// Comprobamos si el elemento i, es es menor que pivot
			while (item[i] < pivot && i < end)
				i++;

			// Comprobamos si el elemento j, es es mayor que pivot
			while (item[j] > pivot && j > start)
				j--;

			// Intercambia si no se han cruzado, y pasamos al siguiente elemento
			if (i <= j) {
				swap(item, i, j);
				i++;
				j--;
			}
		}

		// Repetimos el proceso, haciendo dos barridos
		if (start < j)
			quickSort(item, start, j); // Barrido izquierdo
		if (j < end)
			quickSort(item, i, end); // Barrido derecho

	}
}
