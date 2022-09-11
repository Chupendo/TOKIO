package codes.exercicies.tokio.exercicies.three;

import java.util.stream.IntStream;

public class SumVarargs {

	public static void main(String[] args) {
		System.out.println("sum of 1, 2, 3 and 4 = "+ sum(1,2,3,4));
		
	}
	
	public static int sum(int... a) {
		return IntStream.of(a).sum();
	}
}
