package com.tokio.executor5;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable {

	CyclicBarrier dataCyclicBarrier;

	public Task(CyclicBarrier dataCyclicBarrier) {
		this.dataCyclicBarrier = dataCyclicBarrier;
	}

	@Override
	public void run() {
		try {
			System.out.println("Cargando datos . . .");
			// Espera un tiempo random
			waitRandom();
			
			// Se para hata que todos terminen
			dataCyclicBarrier.await();
			// Reinicia el contador
			dataCyclicBarrier.reset();
			
			System.out.println("Procesando datos . . .");
			// Espera un tiempo random
			waitRandom();
			
			// Se para hata que todos terminen
			dataCyclicBarrier.await();
			
			System.out.println("Cargando resultados . . .");
			// Espera un tiempo random
			waitRandom();
			// Decrementa el contador de countDown
		} catch (

		InterruptedException | BrokenBarrierException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
