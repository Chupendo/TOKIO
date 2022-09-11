package codes.exercicies.tokio.examples.unit6.six;

import java.util.stream.Stream;

public class VarArgsAmbiguo {

	public static void main(String[] args) {
		varTest(1,2,3);	// Correcto
		System.out.println();
		varTest(true,false,true,true); //Correcto
		//varTest(); // ¡Error: amgibuo!
		
	}

	/** Sobrecarga varargs **/
	// metodo con argumento de entrada varargs int
	public static void varTest(Integer ...v) {
		Stream.of(v).forEach(System.out::print);
	}
	
	// metodo con argumento de entrada varargs int
	public static void varTest(boolean ...v) {
		for(int i=0;i<v.length;i++) {
			System.out.print(v[i]);
		}
	}
}
