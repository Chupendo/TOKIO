package example.uni7.book.exer1;

import example.uni7.book.exer1.subpackage.SubclaseOtherPackage;
import example.uni7.book.other.exer1.SubclaseOtherPackage2;

/**
 * Una superclase no puede acceder a los miembros de una subclase, 
 * sin embargo, una subclase, puede acceder a los elementos de la superclase siempre y 
 * cuando sean públicos/protected y adicionalmente a los miembros package (default) 
 * si ambas clases se encuentra en el mismo paquete.
 * 
 * See {@link SubclaseSamePackage}
 * See {@link SubclaseOtherPackage}
 * See {@link SubclaseOtherPackage2}
 * 
 * @author andre
 *
 */
public class Superclase {
		public int atrPublicFather;
		int atrPackageFather;
		protected int atrProtectedFather;
		private int atrPrivateFather;
}
