package com.java.ejercicios.eje4;

public enum TrafficLightSimulator {
	ROJO(1200),VERDE(1000),AMARILLO(1100);
	
	private int tDelay;
	private TrafficLightSimulator(int tDelay) {
		this.tDelay = tDelay;
	}
	
	public int getTDelay() {
		return this.tDelay;
	}
}
