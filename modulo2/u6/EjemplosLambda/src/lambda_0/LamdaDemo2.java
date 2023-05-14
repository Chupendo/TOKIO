package lambda_0;

public class LamdaDemo2 {

	public static void main(String[] args) {
		NumericTest<Integer> isFactorInt = (n, d) -> (n.intValue() % d.intValue()) == 0;
		NumericTest<Double> isFactorDouble = (n, d) -> (n.doubleValue() % d.doubleValue()) == 0;
		NumericTest<Double> lessThan = (n, d) -> n<d;
		
		System.out.println(" 2 is factor of 10? "+ isFactorInt.test(2,10));
		System.out.println(" 2.0 is factor of 10.0? "+ isFactorDouble.test(2.0,10.0));
		System.out.println(" 2.0 < 10.0? "+ lessThan.test(2.0,10.0));
	}

	
	@FunctionalInterface
	public interface NumericTest<T extends Number>{
		boolean test(T n1,T n2);
	}	
}
