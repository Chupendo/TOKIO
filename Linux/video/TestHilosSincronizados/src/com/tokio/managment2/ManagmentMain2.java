package com.tokio.managment2;

import java.util.stream.IntStream;

public class ManagmentMain2 {

	public static void main(String[] args) {
		//Dos subproceso que comparten el mismo array
		MyThread2 mTh = MyThread2.createAndStart("Subprocces #1",IntStream.rangeClosed(1, 500).toArray());
		MyThread2 mTh2 = MyThread2.createAndStart("Subprocces #2",IntStream.rangeClosed(1, 500).toArray());
		try {
			Thread.sleep(260);
			
			mTh.mySuspend();
			System.out.println("Suspending thread: "+mTh.th.getName());
			Thread.sleep(260);
			
			mTh.myResumed();
			System.out.println("Resuem thread: "+mTh.th.getName());
			Thread.sleep(500);
			
			mTh.myStopped();
			System.out.println("Stopped: "+mTh.th.getName());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			mTh.th.join();
			mTh2.th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
