package lambda_0;

public class BlockLamdaDemo {

	public static void main(String[] args) {
		// Factor positivo mas pqueño de un valor
		NumericFunc smallestF = n -> {
			int result = 1;
			
			// Valor absoluto de n
			n = n < 0 ? -n : n;
			
			for(int i=2;i <= n/i; i++) {
				if((n%i)==0) {
					result = i;
					break;
				}
			}
			return result;
		};
		
		
		System.out.println("Smallest factor of 12 is "+ smallestF.func(12));
		System.out.println("Smallest factor of -11 is "+ smallestF.func(-11));

	}
	
	@FunctionalInterface
	public interface NumericFunc{
		int func(int n);
	}
}
