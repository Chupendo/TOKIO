package com.tokio.pinpon;

public class PinPon {
	public String stated = "Pin";

	synchronized public void pin() throws InterruptedException {
		while (true) {
			while (stated.equals("Pon"))
				wait();

			stated = "Pon";
			System.out.print("Pin ");
			notify();
			//Permite cmabiar de hiloa
			Thread.sleep(100);
		}
	}

	synchronized void pon() throws InterruptedException {
		
		while (true) {
			while (stated.equals("Pin"))
				wait();

			stated = "Pin";
			System.out.println("Pon");
			notify();
			//Permite cmabiar de hiloa
			Thread.sleep(100);
		}
	}
}
