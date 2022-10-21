package example.uni7.book.other.exer1;

import example.uni7.book.exer1.SubclaseSamePackage;
import example.uni7.book.exer1.Superclase;
import example.uni7.book.exer1.subpackage.SubclaseOtherPackage;

/**
 * Nota: 
 * Si se crea una instancia del objeto en una clase 
 * ubicada en un paquete distinto a la clase del objeto y este 
 * tiene miembros con los modificadores de acceso protected/defult/private, 
 * no se puede acceder directamente.
 * @author andre
 * 
 * See {@link Superclase}
 * See {@link SubclaseSamePackage}
 * See {@link SubclaseOtherPackage}
 */
public class SubclaseOtherPackage2  {

	@Override
	public String toString() {
		SubclaseOtherPackage obj1 = new SubclaseOtherPackage();
		// TODO Auto-generated method stub
		return "obj1.atrPublicFather: "+obj1.atrPublicFather
				+"obj1.atrProtectedFather: no permit"
				+"obj1.atrPackageFather: no permit"
				+"obj1.atrPrivateFather: no permit";
	}
}
