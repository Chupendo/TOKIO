package examples.heredity.u6.m1.example4;


public class ClassProtectedContaind {
	ClassProtected objClasProtected = new ClassProtected();

	public ClassProtectedContaind() {
		objClasProtected = new ClassProtected();
	}

	public ClassProtectedContaind(int varProtected) {
		this();
		System.out.println(varProtected);
		objClasProtected.varProtected = varProtected;
	}

	/**
	 * Clase protected
	 * 
	 * @author andre
	 *
	 */
	protected class ClassProtected {
		protected int varProtected;
		
		public ClassProtected() {

		}

		public ClassProtected(int varProtected) {
			this.varProtected = varProtected;
		}

		@Override
		public String toString() {
			return super.toString() + " ClassPublic [ varProtected = " + varProtected + " ]";
		}
	}

	@Override
	public String toString() {
		return super.toString() + " ClassPublic [ varProtected = " + objClasProtected.varProtected + " ]";
	}
}
