package com.tokio.ticktock2;

public class TickTock {
	private String state;
	
	public void tick(boolean runable) throws InterruptedException {
		if(runable) {
			state = "tick";
		}
		while(true) {
			while(state.equals("tock")) {
				wait();
			}
			
			notify();
			System.out.print("tick ");
			state = "tock";
		}
	}
	
	public void tock(boolean runable) throws InterruptedException {
		if(runable && state==null) {
			state = "tick";
		}
		while(true) {
			while(state.equals("tick")) {
				wait();
			}
			
			notify();
			System.out.println("tock");
			state = "tick";
		}
	}
}
