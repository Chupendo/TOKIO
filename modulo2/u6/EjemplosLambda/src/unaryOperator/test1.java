package unaryOperator;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class test1 {

	public static void main(String[] args) {
		Function<Integer, Boolean> positive = (n) -> n>=0;
		System.out.println("2 is positive: "+positive.apply(2));

		UnaryOperator<Integer> pow = (n) -> n*n;
		System.out.println("2^2  ="+pow.apply(2));
		
		// First applyed pow function and more later appliyed postive funtion
		System.out.println("2^2  ="+pow.andThen(positive).apply(2));

	}

}
