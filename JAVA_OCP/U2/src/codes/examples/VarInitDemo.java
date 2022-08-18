package codes.examples;

// Ilustra la duración de una variable
public class VarInitDemo {

	public static void main(String[] args) {
		int x=10;
		for(x=0;x<3;x++) {
			int y = -1; // se inicializa cada vez que entra en el bloque
			System.out.println("y is: "+y); // y siempre es -1
			y=100;
			System.out.println("y is now: "+y);
		}

	}

}
