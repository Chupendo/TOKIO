package abstacta.clase.ejemplo;

public class ClaseB extends ClaseA {
	private int a=8;
	private int b=4;
	
	@Override
	public int calcular() {
		return a+b;
	}
	
	@Override
	public int calcular2() {
		return a-b;
	}
	
	@Override
	public int calcular3() {
		return a*b;
	}
	
}
