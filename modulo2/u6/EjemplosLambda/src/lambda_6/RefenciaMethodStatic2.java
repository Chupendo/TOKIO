package lambda_6;

public class RefenciaMethodStatic2 {

	public static void main(String[] args) {
		 boolean result;
		 
		 result = MethodRefDemo.numTest(MethodRefDemo::isPrimo, 3);
		 if(result) System.out.println("3 is Primo");
		 
		 result = MethodRefDemo.numTest(MethodRefDemo::isPar, 2);
		 if(result) System.out.println("2 is Par");
		 
		 result = MethodRefDemo.numTest(MethodRefDemo::isPositive, 22);
		 if(result) System.out.println("22 is Positive");

	}
	
	public interface IntPredicate{
		boolean test(int n);
	}
	
}
