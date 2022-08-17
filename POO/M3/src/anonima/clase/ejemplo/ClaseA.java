package anonima.clase.ejemplo;

public class ClaseA {

	public String atributoA;
	public String atributoB;
	
	public ClaseA() {
		
	}
	
	public ClaseA(String atributoA,String atributoB){
		super();
		this.atributoA=atributoA;
		this.atributoB=atributoB;
	}
	
	@Override
	public String toString() {
		return "Clase A: [atributoA="+atributoA+", atributoB="+atributoB+"]";
	}
	
	public int operarInt(int a,int b) {
		return a+b;
	}
}
