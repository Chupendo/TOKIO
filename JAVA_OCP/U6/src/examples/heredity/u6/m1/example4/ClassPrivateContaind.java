package examples.heredity.u6.m1.example4;

public class ClassPrivateContaind {

	ClassPrivate objClasPrivate;

	public ClassPrivateContaind() {
		objClasPrivate = new ClassPrivate();
	}

	public ClassPrivateContaind(int varPrivate) {
		this();
		//System.out.println(varPrivate);
		objClasPrivate.varPrivate = varPrivate;
	}

	/**
	 * Clase private
	 * Clase no visible para otra clase que no sea
	 * la contendero
	 * @author andre
	 *
	 */
	private class ClassPrivate {
		private int varPrivate;

		public ClassPrivate() {

		}
		public ClassPrivate(int varPrivate) {
			this.varPrivate = varPrivate;
		}
		@Override
		public String toString() {
			return super.toString() + " ClassPublic [ varPrivate = " + varPrivate + " ]";
		}
	}

	public int getVarPrivate() {
		return this.objClasPrivate.varPrivate;
	}

	public void setVarPrivate(int varPrivate) {
		this.objClasPrivate.varPrivate = varPrivate;
	}
	@Override
	public String toString() {
		return super.toString() + " ClassPublic [ varPrivate = " + objClasPrivate.varPrivate + " ]";
	}
}
