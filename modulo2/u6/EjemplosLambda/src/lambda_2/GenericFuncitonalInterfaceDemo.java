package lambda_2;

public class GenericFuncitonalInterfaceDemo {

	public static void main(String[] args) {
		// Determina si b es factor de a
		SomeTest<Integer> isFactor = (a,b)-> (a%b) == 0;
		
		int a = 3,b=4;
		if(isFactor.test(a, b))
			System.out.println(a+" es factor de "+b);
		else
			System.out.println(a+" no es factor de "+b);
	}

	/**
	 * Una interrfaz funcional genérica con dos parémtros
	 * que devuelve un resultado boolean
	 *
	 * @param <T>
	 */
	public interface SomeTest<T>{
		boolean test(T n, T m);
	}
}
