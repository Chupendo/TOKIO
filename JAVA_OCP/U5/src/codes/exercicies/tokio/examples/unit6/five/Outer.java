package codes.exercicies.tokio.examples.unit6.five;

import java.util.stream.IntStream;

// Ejemplo que ilustra el uso de una clase anidad interna de bloque
public class Outer {
	int num[];
	
	Outer(int n[]){
		num = n;
	}
	
	void analyze() {
		Inner inOb = new Inner();
		
		System.out.println("Minimum: "+inOb.min());
		System.out.println("Maximum: "+inOb.max());
		System.out.println("Average: "+inOb.avg());
	}
	
	// Clase interna de bloque
	class Inner{
		int min() {
			return IntStream.of(num).min().orElse(0);
		}
		int max() {
			return IntStream.of(num).max().orElse(0);
		}
		double avg() {
			int sum = IntStream.of(num).sum();
			return (double) (sum/num.length);
		}
	}
}
