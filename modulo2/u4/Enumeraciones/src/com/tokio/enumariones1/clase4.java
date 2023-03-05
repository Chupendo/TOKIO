package com.tokio.enumariones1;

public class clase4 {
	enum Estacion {	PRIMAVERA, VERANO, OTONO, INVIERNO;	};

	public static void main(String[] args) {
		Estacion estacionActual = Estacion.INVIERNO;
		for (Estacion estacion : Estacion.values()) {
			Estacion s = estacion;
			System.out.println(estacion+ ", ordinal: "+s.ordinal());
			
			if(estacionActual.compareTo(estacion)==0) {
				System.out.println("Estacion actual: "+estacionActual);
			}else {
				
				if(estacionActual.compareTo(estacion)>0) {
					System.out.println("Estacion pasada");
				}else {
					if(estacionActual.compareTo(estacion)<0) {
						System.out.println("Estacion aun no pasada");
					}
				}	
			}
		}
	}
}
