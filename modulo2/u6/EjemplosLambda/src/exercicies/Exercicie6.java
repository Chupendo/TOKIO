package exercicies;

public class Exercicie6 {

	public static void main(String[] args) {
		
		Range<Integer> funInt = (n)-> (n>=10)&&(n<=20);
		Range<Double> funDouble = (n)-> (n>=10)&&(n<=20);
		MyTest<Integer> rangeInt =(a,b)->a.test(b);
		MyTest<Double> rangeDouble =(a,b)->a.test(b);		
		
		System.out.println("2c[10,20] = "+rangeInt.testing(funInt,2));
		System.out.println("11.4c[10,20] = "+rangeDouble.testing(funDouble,11.4));
	}

	public interface Range<T extends Number>{
		boolean test(T n);
	}
	
	public interface MyTest<T  extends Number>{
		 boolean testing(Range<T> fun,T n);
	}
}
