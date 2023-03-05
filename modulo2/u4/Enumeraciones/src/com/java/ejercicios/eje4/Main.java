package com.java.ejercicios.eje4;

public class Main {

	public static void main(String[] args) {
		SemaforoThread sTh = new SemaforoThread("semaforo #1",TrafficLightSimulator.VERDE);
		sTh.th.start();
		
		try {
			Thread.sleep(12000);
			sTh.stop=true;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
