package examples.heredity.u6.m1.example4;

public class ClassPublic {
	public int varPublic;
	
	public ClassPublic() {
		
	}
	
	public ClassPublic(int varPublic) {
		this.varPublic = varPublic;
	}
	
	@Override
	public String toString() {
		return super.toString()+" ClassPublic [ varPublic = "+varPublic+" ]";
	}
}
