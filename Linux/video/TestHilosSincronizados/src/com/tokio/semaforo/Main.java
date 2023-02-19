package com.tokio.semaforo;

public class Main {

	public static void main(String[] args) {
		Semaforo sf = new Semaforo();
		VerdeThread vth = VerdeThread.createAndStart("verde #1", sf);
		AmarilloThread ath = AmarilloThread.createAndStart("amarillo #1", sf);
		RojoThread rth = RojoThread.createAndStart("rojo #1", sf);
		
		try {
			vth.th.join();
			ath.th.join();
			rth.th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
