package com.tokio.enumariones1;

public class clase3 {
	enum Estacion{
		//Variables de instancia e inicializacion
		PRIMAVERA(10,20.5F),
		VERANO(23,40),
		OTONO(5.3F,15),
		INVIERNO(-2.1F,10);
		
		//temperatura de cada estancion
		private final float temperaturaMinima;
		private final float temperaturaMaxima;

		//contructor
		Estacion(float minima,float maxima){
			temperaturaMinima=minima;
			temperaturaMaxima=maxima;
		}
		
		//metodos
		public float getTemperaturaMinima() {
			return temperaturaMinima;
		}
		
		public float getTemperaturaMaxima() {
			return temperaturaMaxima;
		}
		
		public float diferenciaTemperatura() {
			return temperaturaMaxima - temperaturaMinima;
		}
	}


	public static void main(String[] args) {
		
		for(Estacion estacion : Estacion.values()) {
			System.out.println(estacion+": (min,max)=("+estacion.getTemperaturaMinima()+","+estacion.getTemperaturaMaxima()+"), difTemp="+estacion.diferenciaTemperatura());
		}
	}
}
