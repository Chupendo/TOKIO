package examples.heredity.u6.m1.example4;

public class DemoClassDerivadaProtected extends ClassProtectedContaind{

	public DemoClassDerivadaProtected() {
		super(1);
	}
	public static void main(String[] args) {
		DemoClassDerivadaProtected cDer = new DemoClassDerivadaProtected();
		System.out.println("varProtected: "+cDer.objClasProtected.varProtected);
		System.out.println(cDer.toString());
	}

}
