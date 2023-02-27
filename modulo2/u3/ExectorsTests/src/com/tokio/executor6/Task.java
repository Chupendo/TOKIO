package com.tokio.executor6;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {

	CountDownLatch loadDataCountDown;
	CountDownLatch processDataCountDown;

	public Task(CountDownLatch loadDataCountDown, CountDownLatch processDataCountDown) {
		this.loadDataCountDown = loadDataCountDown;
		this.processDataCountDown = processDataCountDown;
		
	}
	@Override
	public void run() {

		System.out.println("Cargando datos . . .");
		// Espera un tiempo random
		waitRandom();
		// Decrementa el contador de countDown
		loadDataCountDown.countDown();

		System.out.println("Procesando datos . . .");
		// Espera un tiempo random
		waitRandom();
		// Decrementa el contador de countDown
		processDataCountDown.countDown();

		System.out.println("Cargando resultados . . .");
		// Espera un tiempo random
		waitRandom();
		// Decrementa el contador de countDown
		

	}

	private static void waitRandom() {
		Random random = new Random();
		try {
			Thread.sleep(500 * random.nextInt(10));
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

}
