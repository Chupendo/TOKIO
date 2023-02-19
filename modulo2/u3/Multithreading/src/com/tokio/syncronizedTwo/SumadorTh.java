package com.tokio.syncronizedTwo;

import java.util.Arrays;

public class SumadorTh implements Runnable {
	//static private int[] nums;
	private int[] nums;
	public Thread th;
	//static private ArraySum aSum; //Se sincroniza
	private ArraySum aSum;//No se sincroniza
	
	public SumadorTh(String name,int[] nums) {
		this.nums = nums;
		th = new Thread(this,name);
		aSum = new ArraySum();
	}
	
	public static SumadorTh createAndStart(String name, int[] nums) {
		SumadorTh sTh = new SumadorTh(name, nums);
		sTh.th.start();
		return sTh;
	}
	
	
	@Override
	public void run() {
		System.out.println(th.getName()+ " strating");
		synchronized (nums) { //Si "nums" no es compartido por el resto de
				//innstnaicas no 
			System.out.print(th.getName()+" list: ");
			Arrays.asList(nums).forEach(System.out::print);
			System.out.println(" sum: "+aSum.sum(nums));	
		}
		
		System.out.println(th.getName()+ " ending");

	}

}
