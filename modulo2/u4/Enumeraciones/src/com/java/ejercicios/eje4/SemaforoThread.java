package com.java.ejercicios.eje4;

public class SemaforoThread implements Runnable {
	TrafficLightSimulator light;
	Thread th;
	boolean stop;
	TrafficLightService service;
	public SemaforoThread(String name, TrafficLightSimulator light) {
		this.th = new Thread(this,name);
		this.stop = false;
		this.light = light;
		this.service = new TrafficLightService();
	}
	
	
	@Override
	public void run() {
		synchronized (service) {
			while(!stop) {
				try {
					System.out.println("Light ("+Thread.currentThread().getName()+"): "+light);
					this.service.light(light);
					this.light = service.waitToChange(light);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
