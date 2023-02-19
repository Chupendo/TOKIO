package com.tokio.synchronizedOne;

public class RunSync {

	public static void main(String[] args) {
		int nums[]= {1,2,3,4,5};
		OperationThread opth1 = OperationThread.creaOperationThread("Child #1", nums);
		OperationThread opth2 = OperationThread.creaOperationThread("Child #2", nums);
		
		try {
			opth1.thrd.join();
			opth2.thrd.join();
		}catch(InterruptedException e) {
			System.err.println("Main Thread interrumped,");
		}

	}

}
