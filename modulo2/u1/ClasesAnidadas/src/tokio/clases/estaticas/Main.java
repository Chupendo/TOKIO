package tokio.clases.estaticas;

import tokio.clases.estaticas.ClaseA.ClaseB;

public class Main {
	
	
	public static void main(String[] args) {
		ClaseA cA = new ClaseA();
		cA.msgA();
		System.out.println("externo_x: "+cA.externo_x+", externo_y: "+cA.externo_y);
		System.out.println();
		
		//ClaseA.ClaseB cB = new ClaseA.ClaseB();
		ClaseB cB = new ClaseB();
		cB.msgB();
		cB.mostrar();
		
		System.out.println();
		ClaseC cC = new ClaseC();
		cC.msgA();
		
		System.out.println();
		ClaseD cD = new ClaseD();
		cD.msgB();
	}
}
