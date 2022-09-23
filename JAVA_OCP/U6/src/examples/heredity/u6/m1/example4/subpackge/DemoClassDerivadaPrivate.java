package examples.heredity.u6.m1.example4.subpackge;

import examples.heredity.u6.m1.example4.ClassPrivateContaind;

public class DemoClassDerivadaPrivate extends ClassPrivateContaind{

	public DemoClassDerivadaPrivate() {
		super(1);
	}
	public static void main(String[] args) {
		DemoClassDerivadaPrivate cDer = new DemoClassDerivadaPrivate();
		//cDer.setVarPrivate(2);
		System.out.println("varProtected: "+cDer.getVarPrivate());
		//La clase no es visible
		//System.out.println("varProtected: "+cDer.objClasPrivate.toString());
		System.out.println(cDer.toString());
	}

}
