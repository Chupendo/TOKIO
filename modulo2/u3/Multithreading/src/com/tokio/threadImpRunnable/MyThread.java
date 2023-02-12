package com.tokio.threadImpRunnable;

public class MyThread implements Runnable {
	String thrName;
	
	public MyThread(String thrName) {
		
		this.thrName = thrName;
	}
	
	//Punto de entrada del subproceso
	@Override
	public void run() {
		System.out.println(thrName+" starting");
		try {
			for(int count=0;count<10;count++) {
			Thread.sleep(400);
			System.out.println("In "+thrName+", count is "+ count);
			}
		} catch (InterruptedException e) {
			System.err.println(thrName+" interrupted"
					+"\n"+e.getMessage());
		}
		System.out.println(thrName+" terminating");

	}
}
