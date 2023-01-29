package tokio.clases.inseternas.local;

import tokio.clases.inseternas.local.ClaseA.ClaseB;

public class Main {

	public static void main(String[] args) {
		ClaseA cA = new ClaseA();
		ClaseB cB = (new ClaseA()).new ClaseB();
		
		//dato se modifica cuando se crea una instnaica de A
		System.out.println(cA.dato);
		//dato es descnocido para ClaseB
		System.out.println(cB.nameCB); 
		
	}

}
