package example.uni7.book.exer1.subpackage;

import example.uni7.book.exer1.Superclase;

public class SubclaseOtherPackage extends Superclase {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "atrPublicFather: "+atrPublicFather
				+"atrProtectedFather: "+atrProtectedFather
				+"atrPackageFather: no permit"
				+"atrPrivateFather: no permit";
	}
}
