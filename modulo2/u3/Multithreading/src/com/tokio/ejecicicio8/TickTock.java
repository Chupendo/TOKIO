package com.tokio.ejecicicio8;

public class TickTock {
	private String state;
	
	public void printTick() throws InterruptedException {
		synchronized (this) {
			if(state==null) {
				state = "tick";
			}
			
			while(state.equals("tock")) {
				wait();
			}
			
			System.out.print("tick ");
			state="tock";
			Thread.sleep(500);
			notify();
		}
		
	}
	
	public void printTock() throws InterruptedException {
		synchronized (this) {
			if(state==null) {
				state = "tick";
			}
			
			while(state.equals("tick")) {
				wait();
			}
			
			System.out.println("tock ");
			state="tick";
			Thread.sleep(500);
			notify();
		}
	}
}
