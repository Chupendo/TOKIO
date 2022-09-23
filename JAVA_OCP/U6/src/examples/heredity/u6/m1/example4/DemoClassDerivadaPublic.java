package examples.heredity.u6.m1.example4;

public class DemoClassDerivadaPublic extends ClassPublic{

	public DemoClassDerivadaPublic() {
		super(1);
	}
	public static void main(String[] args) {
		DemoClassDerivadaPublic cDer = new DemoClassDerivadaPublic();
		System.out.println("varPublic: "+cDer.varPublic);
		System.out.println(cDer.toString());
	}

}
