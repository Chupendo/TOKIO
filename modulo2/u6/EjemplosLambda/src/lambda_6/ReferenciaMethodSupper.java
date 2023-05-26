package lambda_6;

public class ReferenciaMethodSupper {

	public static void main(String[] args) {
		
		ClaseHija ch = new ClaseHija();
		
		MyPredicate myPre1 = ch.myPre;
		
		System.out.println(myPre1.test(2));
		System.out.println(ch.myPre.test(2));
	}

	interface MyPredicate{
		boolean test(int n);
	}
}
