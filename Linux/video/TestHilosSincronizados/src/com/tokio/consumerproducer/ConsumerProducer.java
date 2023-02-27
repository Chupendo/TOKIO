package com.tokio.consumerproducer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsumerProducer {

	List<Integer> lNums = new ArrayList<Integer>();
	private static final int MAX=5;
	
	synchronized public void consumer() throws InterruptedException {
		while(true) {
			if(lNums.size()==MAX) {
				wait();
			}
			
			//
			Random rd = new Random();
			int number = rd.nextInt();
			System.out.println(Thread.currentThread().getName()+" number= "+number);
			lNums.add(number);
			
			//
			notify();
			
			//
			Thread.sleep(200);
		}
	}
	
	synchronized public void producer() throws InterruptedException {
		while(true) {
			if(lNums.isEmpty()) {
				wait();
			}
			
			//
			int number = lNums.get(lNums.size()-1);
			System.out.println(Thread.currentThread().getName()+" number= "+number);
			lNums.remove(lNums.size()-1);
			
			//
			notify();
			
			//
			Thread.sleep(200);
		}
	}
	
}
