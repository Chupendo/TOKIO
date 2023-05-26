package supplier;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class example1 {

	public static void main(String[] args) {
		IntSupplier genInt = ()->{
			Random rm = new Random();
			return rm.nextInt();
		};
		int[] arInt = IntStream.generate(genInt).limit(50).peek(System.out::println).toArray();
	}
}
