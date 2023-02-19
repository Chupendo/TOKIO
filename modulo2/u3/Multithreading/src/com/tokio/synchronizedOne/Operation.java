package com.tokio.synchronizedOne;


public class Operation {
	private int sum;
	
	synchronized int sumArray(int nums[]) {
		//inicializamos
		sum = 0;		
		for(Integer num: nums) {
			sum += num;
			System.out.println("Running total for "+Thread.currentThread().getName()+" is "+sum);
			try {
				//Duerme el proceso x ms
				//esto permite intercambiar tareas
				Thread.sleep(500);
			}catch(InterruptedException e) {
				System.err.println("Thread interrumped.");
			}
		}
		return sum;
	}
}
