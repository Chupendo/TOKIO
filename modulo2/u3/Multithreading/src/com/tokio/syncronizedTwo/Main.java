package com.tokio.syncronizedTwo;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		SumadorTh th1 = SumadorTh.createAndStart("Sum #1", IntStream.generate(()->{
			Random rd = new Random();
			return rd.nextInt();
		}).limit(20).toArray());
		
		SumadorTh th2 = SumadorTh.createAndStart("Sum #2", IntStream.generate(()->{
			Random rd = new Random();
			return rd.nextInt();
		}).limit(20).toArray());
		
		try {
			th1.th.join();
			th2.th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
