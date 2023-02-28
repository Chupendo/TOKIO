package com.tokio.safe;

import java.util.Random;

public class Application {
	public static void main(String[] args) {
			Estacionamiento est = new Estacionamiento();
			
			while(true) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						if(!est.estacionar(new Coche(new Random().nextInt(9000)+1000, new Random().nextInt(120)))) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
				}).start();
			}
		
		
	}
}
