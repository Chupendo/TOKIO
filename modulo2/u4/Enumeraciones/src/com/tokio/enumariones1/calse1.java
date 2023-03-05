package com.tokio.enumariones1;

public class calse1 {
	enum Direccion { ARRIBA, ABAJO, IZQUIERDA, DERECHA;
		
		public static boolean isDireccion(Direccion dir) {
			
			if(dir.equals(ARRIBA) || dir.equals(ABAJO) || dir.equals(IZQUIERDA) || dir.equals(DERECHA)) {
				return true;
				}
			return false;		
			}
		
		public static Direccion toDireccion(String dir) {
			Direccion aux = null;
			for(Direccion direccion:Direccion.values()) {
				if(dir.equalsIgnoreCase(direccion.name())) {
					aux = direccion;
				}
			}
			return aux;
		}
			
	};

	private static Direccion direccion;

	public static void main(String[] args) {
		direccion = Direccion.ABAJO;
		
		System.out.println(direccion+", es direcicon? "+Direccion.isDireccion(direccion));
		
		System.out.println(Direccion.toDireccion("centro"));
		System.out.println(Direccion.toDireccion("ARRIBA"));
	}
}
