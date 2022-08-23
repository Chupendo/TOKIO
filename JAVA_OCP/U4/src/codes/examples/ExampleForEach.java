package codes.examples;

public class ExampleForEach {

	public static void main(String[] args) {
		// Declaracion de un vector
		int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 } };

		// Mostramos valor inicial de vector
		System.out.print("Elementos iniciales de vector: \n{\n");
		for (int vector[] : matriz) {
			System.out.print("{");
			for (int elemento : vector) {
				System.out.print(" " + elemento);
			}
			System.out.println(" }");
		}
		System.out.println("}");

		// Realizmaos una operaicon de elemento
		System.out.print("Realizamos operacion con los elementos del vector --> elemento*2: \n{\n");
		for (int vector[] : matriz) {
			System.out.print("{");
			for (int elemento : vector) {
				elemento = elemento * 2;
				System.out.print(" " + elemento);
			}
			System.out.println(" }");
		}
		System.out.println("}");

		// Mostramso los elemenos de vector tras finalizar la operacion de elemento
		System.out.print("Elementos de vector al finailzar la operacion: \n{\n");
		for (int vector[] : matriz) {
			System.out.print("{");
			for (int elemento : vector) {
				System.out.print(" " + elemento);
			}
			System.out.println(" }");
		}
		System.out.println("}");

		// Los elemenos de la matriz no se ven alterados

		//--------------------------------------
		// Realizmaos una operaicon de elemento y lo guardamso en la refencia
		short i = 0, j = 0;
		System.out.print("Realizamos operacion con los elementos del vector --> matriz[i][j]=elemento*2: \n{\n");
		for (int vector[] : matriz) {
			j = 0;
			System.out.print("{");
			for (int elemento : vector) {
				elemento = elemento * 2;
				matriz[i][j] = elemento;
				j++;
				System.out.print(" " + elemento);
			}
			i++;
			System.out.println(" }");
		}
		System.out.println("}");

		// Mostramso los elemenos de vector tras finalizar la operacion de elemento
		System.out.print("Elementos de vector al finailzar la operacion: \n{\n");
		for (int vector[] : matriz) {
			System.out.print("{");
			for (int elemento : vector) {
				elemento = elemento * 2;
				System.out.print(" " + elemento);
			}
			System.out.println(" }");
		}
		System.out.println("}");
		
		// Los elemenos de la matriz se ven alterados
	}
}
