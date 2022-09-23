package examples.heredity.u6.m1.example4;

public class DemoClassDerivadaDefault extends ClassDefault{

	public DemoClassDerivadaDefault() {
		super(2);
	}
	public static void main(String[] args) {
		DemoClassDerivadaDefault cDer = new DemoClassDerivadaDefault();
		System.out.println("varDefault: "+cDer.varDefault);
		System.out.println(cDer.toString());
	}

}
