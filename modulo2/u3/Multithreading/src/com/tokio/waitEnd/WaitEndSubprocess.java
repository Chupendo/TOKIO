package com.tokio.waitEnd;

public class WaitEndSubprocess {

	public static void main(String[] args) {
		System.out.println("Main thread started");
		MyThread subp1 = MyThread.createAndStart("Child 1#");
		while(subp1.th.isAlive()) {
			System.out.println("wait to "+subp1.th.getName()+" finished!");
		}
		
		MyThread subp2 = MyThread.createAndStart("Child 2#");
		try {
			//Bloked main thead until subp3 ending
			subp2.th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		MyThread subp3 = MyThread.createAndStart("Child 3#");
		try {
			//Bloked main thead until subp3 ending
			subp3.th.join(); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		System.out.println("Main thread ending");
	}

}
