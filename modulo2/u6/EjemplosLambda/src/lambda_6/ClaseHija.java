package lambda_6;

import lambda_6.ReferenciaMethodSupper.MyPredicate;

public class ClaseHija extends SuperClase {
	MyPredicate myPre = super::method;
	
	@Override
	boolean method(int n) {
		System.out.println("metodo clase hija");
		return !super.method(n);
	}
}
