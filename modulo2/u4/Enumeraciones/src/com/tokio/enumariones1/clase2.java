package com.tokio.enumariones1;

public class clase2 {
	enum Direccion { ARRIBA, ABAJO, IZQUIERDA, DERECHA};


	public static void main(String[] args) {
		
		for (Direccion direccion: Direccion.values()) {
			System.out.println(direccion);
		}
		System.out.println("----");
		System.out.println(Direccion.valueOf("ARRIBA"));
		try {
		System.out.println(Direccion.valueOf("arriba"));
		}catch (IllegalArgumentException iae) {
			System.err.println("No es una direccion");
		}
	}
}
