package lambda_6;

public class RefernciaMethodGenerico {

	public static void main(String[] args) {
		SomeTest<Integer> mRef = ClassMethGen::myGenMeth;
		
		boolean r = mRef.test(3, 2);
		System.out.println("r= "+r);

	}
	
	public interface SomeTest<T>{
		boolean test(T n, T m);
	}
	
}
