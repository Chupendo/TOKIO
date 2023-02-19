package com.tokio.ticktock;

public class TickTock {
	public String state; 
	
	synchronized void tick(boolean running) {
		if(running) {
			state = "ticked";
			notify(); //notifica los sub a la espera
			return;
		}
		
		System.out.print("Tick ");
		
		state = "ticked"; //estado actual
		notify(); //ejecuta tock
		try {
			while(!state.equals("tocked"))
				wait(); //espera que termine tock
		}catch (Exception e) {
			System.err.println("Hilo interrumpido");
		}
	}
	
	synchronized void tock(boolean running) {
		if(running) {
			state = "tocked";
			notify(); //notifica los sub a la espera
			return;
		}
		
		System.out.println("Tock");
		
		state = "tocked"; //estado actual
		notify(); //ejecuta tock
		try {
			while(!state.equals("ticked"))
				wait(); //espera que termine tick
		}catch (Exception e) {
			System.err.println("Hilo interrumpido");
		}
	}
	


}
