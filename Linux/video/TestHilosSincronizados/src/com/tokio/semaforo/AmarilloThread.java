package com.tokio.semaforo;

public class AmarilloThread implements Runnable {
	
	Thread th;
	Semaforo sf;
	
	public AmarilloThread(String name, Semaforo sf) {
		this.th = new Thread(this,name);
		this.sf = sf;
	}
	
	public static AmarilloThread createAndStart(String name, Semaforo sf) {
		AmarilloThread rth = new AmarilloThread(name, sf);
		rth.th.start();
		return rth;
	}
	@Override
	public void run() {
		try {
			sf.amarillo(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
