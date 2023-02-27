package com.tokio.syncronizedThree.one;

import java.util.Random;
import java.util.stream.IntStream;

public class Main2 {

	public static void main(String[] args) {
		Random rd = new Random();
		final int[] op1 = IntStream.generate(() -> rd.nextInt()).limit(10).toArray();
		final int[] op2 = IntStream.generate(() -> rd.nextInt()).limit(10).toArray();
		OperationsArray2 operationsArray1 = new OperationsArray2();
		OperationsArray2 operationsArray2 = new OperationsArray2();

		Runnable r1 = () -> { operationsArray1.sum(op1); };
		//r1 y r2 comparte el mismo objeto, se sincroniza
		Runnable r2 = () -> { operationsArray1.sum(op1); };
		//r1 y r2 no comparte el mismo objeto, no se sincroniza (opX no influye)
		//Runnable r2 = () -> { operationsArray2.sum(op1); };

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
