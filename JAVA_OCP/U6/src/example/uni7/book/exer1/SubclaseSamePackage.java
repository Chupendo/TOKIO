package example.uni7.book.exer1;

public class SubclaseSamePackage extends Superclase {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "atrPublicFather: "+atrPublicFather
				+"atrProtectedFather: "+atrProtectedFather
				+"atrPackageFather: "+atrPackageFather+" "
				+"atrPrivateFather: no permit";
	}
}
