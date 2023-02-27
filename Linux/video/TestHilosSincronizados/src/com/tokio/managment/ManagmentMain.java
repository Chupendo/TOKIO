package com.tokio.managment;

public class ManagmentMain {

	public static void main(String[] args) {
		MyThread mTh = MyThread.createAndStart("Subprocces #1");
		
		try {
			Thread.sleep(260);
			
			mTh.mySuspend();
			System.out.println("Suspending thread.");
			Thread.sleep(260);
			
			mTh.myResumed();
			System.out.println("Resuem thread.");
			Thread.sleep(500);
			
			mTh.myStopped();
			System.out.println("Stopped.");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			mTh.th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
