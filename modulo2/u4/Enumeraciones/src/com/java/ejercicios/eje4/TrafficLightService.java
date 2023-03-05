package com.java.ejercicios.eje4;


public class TrafficLightService {
	
	private  boolean changed = false;
	
	public void light(TrafficLightSimulator ligth) throws InterruptedException {
		Thread.sleep(ligth.getTDelay());
		this.changed = true;
		
		notify();
	}
	
	public TrafficLightSimulator changeLight(TrafficLightSimulator light) {

		return TrafficLightSimulator.values()[(light.ordinal()+1)%TrafficLightSimulator.values().length];

	}
	
	public TrafficLightSimulator waitToChange(TrafficLightSimulator light) throws InterruptedException {
		while(!changed) {
			wait();
		}
		this.changed = false;
		return changeLight(light);
	}
}
