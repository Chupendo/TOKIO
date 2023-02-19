package com.tokio.semaforo;

public class RojoThread implements Runnable {
	
	Thread th;
	Semaforo sf;
	
	public RojoThread(String name, Semaforo sf) {
		this.th = new Thread(this,name);
		this.sf = sf;
	}
	
	public static RojoThread createAndStart(String name, Semaforo sf) {
		RojoThread rth = new RojoThread(name, sf);
		rth.th.start();
		return rth;
	}
	@Override
	public void run() {
		try {
			sf.rojo(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
