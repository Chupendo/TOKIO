package com.tokio.ticktock2;

public class TickTockRun {

	public static void main(String[] args) {
		final TickTock tktk = new TickTock();
		Runnable tick = () -> {
			try {
				synchronized (tktk) {
					tktk.tick(true);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Runnable tock = () -> {
			try {
				synchronized (tktk) {
					tktk.tock(true);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread th1 = new Thread(tick, "Tick #1");
		Thread th2 = new Thread(tock, "Tock #1");
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
