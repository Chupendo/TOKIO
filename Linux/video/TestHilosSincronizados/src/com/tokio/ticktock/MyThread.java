package com.tokio.ticktock;

public class MyThread implements Runnable {
	Thread th;
	TickTock ttOb;
	
	public MyThread(String name, TickTock tt) {
		this.th = new Thread(this,name);
		ttOb = tt;
	}
	public static MyThread createAndStart(String name, TickTock tt) {
		MyThread myThrd = new MyThread(name, tt);
		myThrd.th.start();
		return myThrd;
	}
	
	
	@Override
	public void run() {
		if(th.getName().compareTo("Tick")==0) {
			for(int i =0;i<5;i++) ttOb.tick(true);
			ttOb.tick(false);
		}else {
			for(int i =0;i<5;i++) ttOb.tock(true);
			ttOb.tock(false);
		}
	}

}
