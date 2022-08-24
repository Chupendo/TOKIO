package codes.exercicie.tokio;

/**
 * Escribe un programa que genere una serie de 10 números aleatorios ordenados.
 * 
 * @author Andres Ruiz Penuela
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		int vector[] = new int[10];

		for (int i = 0; i < vector.length; i++) {
			vector[i] = (int) Math.round(Math.random() * 10);
		}

		System.out.println("Vector desonernado: ");
		mostrar(vector);
		ordenar(vector);
		System.out.println("Vector onernado: ");
		mostrar(vector);
	}

	public static void mostrar(int[] vector) {
		System.out.print("Vector: { ");
		for (int elem : vector) {
			System.out.print(elem + " ");
		}
		System.out.println("}");
	}
	
	public static void ordenar(int[] vector) {
		for(int i=0;i<vector.length;i++) {
			for(int j=i+1;j<vector.length;j++) {
				if(vector[i]>vector[j]) {
					// intercambio de valores
					vector[i]=vector[i]+vector[j];
					vector[j]=vector[i]-vector[j];
					vector[i]=vector[i]-vector[j];
				}
			}
		}
	}
}
