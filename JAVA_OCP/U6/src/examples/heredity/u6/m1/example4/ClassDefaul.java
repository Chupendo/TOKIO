package examples.heredity.u6.m1.example4;

class ClassDefault {
	int varDefault;

	public ClassDefault() {

	}

	public ClassDefault(int varDefault) {
		this.varDefault = varDefault;
	}

	@Override
	public String toString() {
		return super.toString() + " ClassPublic [ varDefault = " + varDefault + " ]";
	}
}
