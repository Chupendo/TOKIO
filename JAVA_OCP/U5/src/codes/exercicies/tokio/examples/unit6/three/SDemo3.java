package codes.exercicies.tokio.examples.unit6.three;

public class SDemo3 {

	public static void main(String[] args) {
		BloqueStatic bq = new BloqueStatic("Inside Constructor");
		
		System.out.println("Square root of 2 is "+ BloqueStatic.rootOf2);
		System.out.println("Square root of 3 is "+ BloqueStatic.rootOf3);
	}
}
