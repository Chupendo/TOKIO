package com.tokio.ticktock;

public class ThreadCom {
	public static void main(String[] args) {
		TickTock tt = new TickTock();
		MyThread mt1 = MyThread.createAndStart("Tick", tt);
		MyThread mt2 = MyThread.createAndStart("Tock", tt);
		
		
		try {
			mt1.th.join();
			mt2.th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
