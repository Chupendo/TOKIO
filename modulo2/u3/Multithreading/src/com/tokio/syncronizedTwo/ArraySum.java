package com.tokio.syncronizedTwo;

public class ArraySum {
	private int sum;
	
	synchronized public int sum(int[] nums) {
		sum = 0;
		for(int i=0;i<nums.length;i++) {
			System.out.println(Thread.currentThread().getName()+ "is summing");
			sum+=nums[i];
		
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}
}
