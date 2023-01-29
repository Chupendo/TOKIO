package tokio.clases.estaticas;

public class ClaseD extends ClaseA.ClaseB {
	@Override
	public void msgB() {
		System.out.println("Soy la clase hija y puedo llamar a la clase padre");
		super.msgB();
		super.mostrar();
	}
}
