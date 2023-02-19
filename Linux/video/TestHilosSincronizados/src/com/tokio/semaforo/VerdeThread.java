package com.tokio.semaforo;

public class VerdeThread implements Runnable {
	
	Thread th;
	Semaforo sf;
	
	public VerdeThread(String name, Semaforo sf) {
		this.th = new Thread(this,name);
		this.sf = sf;
	}
	
	public static VerdeThread createAndStart(String name, Semaforo sf) {
		VerdeThread rth = new VerdeThread(name, sf);
		rth.th.start();
		return rth;
	}
	@Override
	public void run() {
		try {
			sf.verde(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
