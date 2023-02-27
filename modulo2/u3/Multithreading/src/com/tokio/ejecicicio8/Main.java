package com.tokio.ejecicicio8;

public class Main {
	public static void main(String[] args) {
		final TickTock tt = new TickTock();
		Runnable r1 = ()->{
			for(int i=0;i<5;i++) {
				try {
					tt.printTick();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Runnable r2 = ()->{
			for(int i=0;i<5;i++) {
				try {
					tt.printTock();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread th1 = new Thread(r1,"tick");
		Thread th2 = new Thread(r2,"tock");
		
		th1.start();
		th2.start();
		
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
