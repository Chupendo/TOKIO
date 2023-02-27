package com.tokio.syncronizedThree.one;

public class OperationsArray2 {

	synchronized public int sum(int [] nums) {
		System.out.println("entro");
		int sum = 0;
		for(int i=0;i<nums.length;i++) {
			
			sum += nums[i];
			System.out.println(	Thread.currentThread().getName()+" "+i+":"+sum);
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}
}
