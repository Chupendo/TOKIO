package codes.examples;

public class ExampleArrayRefence {

	public static void main(String[] args) {
		int [] vector = {1,2,3}; // Declara e inicaliza un nuevo vector
		
		// Mostramos valor inicial
		System.out.print("Valor inicial del vector: {" );
		for(int elemento:vector) {
			System.out.print(" "+elemento);
		}
		System.out.println(" }");
		
		// Vector de refencia: Vector 2 hace refencia a vector
		int vector2[]= vector, i=0;
		System.out.print("Valor inicial del vecto2: {" );
		for(int elemento:vector2) {
			System.out.print(" "+elemento);
		}
		System.out.println(" }");
		
		// Modificmaos los elementos de Vector 2
		for(int elemento:vector) {
			vector2[i]=elemento*2;
			i++;
		}
		
		System.out.print("Valor de vector despues de cambiar vector 2: {" );
		for(int elemento:vector) {
			System.out.print(" "+elemento);
		}
		System.out.println(" }, vector 2 hace refenia a vector");
	}
}
