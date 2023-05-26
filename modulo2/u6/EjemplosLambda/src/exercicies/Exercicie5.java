package exercicies;

public class Exercicie5 {

	public static void main(String[] args) {
		
		Range<Integer> rangeInt = (n)-> (n>=10)&&(n<=20);
		
		System.out.println("2c[10,20] = "+rangeInt.test(2));
		System.out.println("11c[10,20] = "+rangeInt.test(11));
	}

	public interface Range<T extends Number>{
		boolean test(T n);
	}
}
