package tokio.clases.internas.a;

import tokio.clases.internas.a.ClaseA.ClaseAnStatic;

public class Main {

	public static void main(String[] args) {
		ClaseA cA = new ClaseA();

		ClaseAnStatic cAnS = cA.new ClaseAnStatic();
		cAnS.mostrar();
	}
}
