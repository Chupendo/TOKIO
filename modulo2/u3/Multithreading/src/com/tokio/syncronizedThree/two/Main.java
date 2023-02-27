package com.tokio.syncronizedThree.two;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		Random rd = new Random();
		final int[] op1 = IntStream.generate(() -> rd.nextInt()).limit(10).toArray();
		final int[] op2 = IntStream.generate(() -> rd.nextInt()).limit(10).toArray();
		OperationsArray operationsArray = new OperationsArray();

		Runnable r1 = () -> {
			synchronized (operationsArray) {
				operationsArray.sum(op1);
			}

		};
		Runnable r2 = () ->  {
			synchronized (operationsArray) {
				operationsArray.sum(op2);
			}
		};

		Thread th1 = new Thread(r1, "sum #1");
		Thread th2 = new Thread(r2, "sum #2");
		th1.start();
		th2.start();
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
