package com.tokio.mejoraThread;

public class MejoraThread {

	public static void main(String[] args) {
		//Created a subprocess
		MyThread mTh = new MyThread("Child #1");
		
		//Lanch the process
		mTh.th.start();
				
		try {
			//waitd to end the process
			mTh.th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
