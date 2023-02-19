package com.tokio.pinpon;

public class Main {

	public static void main(String[] args) {
		final PinPon pp = new PinPon();

		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pp.pin();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}, "Pin");

		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pp.pon();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}, "Pon");
		
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
