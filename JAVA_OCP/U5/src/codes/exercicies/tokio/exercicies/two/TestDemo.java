package codes.exercicies.tokio.exercicies.two;

public class TestDemo {

	public static void main(String[] args) {
		Test a = new Test(3);
		Test b = new Test(4);
		
		System.out.println("a= "+a.a);
		System.out.println("b= "+b.a);
		
		System.out.println("swap");
		a.swap(b);
		
		System.out.println("a= "+a.a);
		System.out.println("b= "+b.a);
	}
}
