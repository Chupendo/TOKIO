package codes.examples;

public class ExampleForEach2 {

	public static void main(String[] args) {
		// Declaracion de un vector
		int []vector = {1,2,3};
		
		// Mostramos valor inicial de vector
		System.out.print("Elementos iniciales de vector: {");
		for(int elemento : vector) {
			System.out.print(" "+elemento);
		}
		System.out.println(" }");
		
		// Realizmaos una operaicon de elemento
		System.out.print("Realizamos operacion con los elementos del vector --> elemento*2: {");
		for(int elemento : vector) {
			elemento = elemento*2;
			System.out.print(" "+elemento);
		}
		System.out.println(" }");
		
		// Mostramso los elemenos de vector tras finalizar la operacion de elemento
		System.out.print("Elementos de vector al finailzar la operacion: {");
		for(int elemento : vector) {
			System.out.print(" "+elemento);
		}
		System.out.println(" }");
		
		// Los elemenos de vector no se ven alterados
	}
}
