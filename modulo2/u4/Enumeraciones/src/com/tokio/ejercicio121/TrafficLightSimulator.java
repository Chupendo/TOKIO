package com.tokio.ejercicio121;

public class TrafficLightSimulator implements Runnable {
	private TrafficLightColor tlc; // continte el color del semáforo
	boolean stop = false; // true para detener el semáforo
	boolean changed = false; // true cuando la luz ha cambiado

	public TrafficLightSimulator(TrafficLightColor init) {
		this.tlc = init;
	}

	public TrafficLightSimulator() {
		this.tlc = TrafficLightColor.RED;
	}

	@Override
	public void run() {

		while (!stop) {
			try {
				switch (tlc) {
				case GREEN:
					//10s
					Thread.sleep(10000);
					break;
				case YELLOW:
					//2s
					Thread.sleep(2000);
					break;
				case RED:
					//12s
					Thread.sleep(12000);
					break;
				default:
					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			changeColor();
		}
	}
	
	public synchronized void changeColor() {
		switch(tlc) {
		case RED:
			tlc = TrafficLightColor.GREEN;
			break;
		case YELLOW:
			tlc = TrafficLightColor.RED;
			break;
		case GREEN:
			tlc = TrafficLightColor.YELLOW;
			break;
		}
		changed = true;
		notify();
	}
	
	public synchronized void waitForChange() {
		try {
			while(!changed) {
				wait();
			}
			changed = false;
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	public synchronized TrafficLightColor getColor() {
		return tlc;
	}
	
	public synchronized void cancel() {
		stop = true;
	}
}
