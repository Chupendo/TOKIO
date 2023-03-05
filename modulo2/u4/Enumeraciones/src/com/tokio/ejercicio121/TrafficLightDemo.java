package com.tokio.ejercicio121;

public class TrafficLightDemo {

	public static void main(String[] args) {
		TrafficLightSimulator tl = new TrafficLightSimulator(TrafficLightColor.GREEN);
		Thread th = new Thread(tl);
		th.start();
		
		for(int i=0;i<9;i++) {
			System.out.println(tl.getColor());
			tl.waitForChange();
		}
		
		tl.cancel();
		
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
