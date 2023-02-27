package com.tokio.executor6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorOne {

	public static void main(String[] args) {
		//El contador empieza de 4
		CountDownLatch loadProcess = new CountDownLatch(4);
		CountDownLatch processProcess = new CountDownLatch(4);
		
		
		ExecutorService ex = Executors.newCachedThreadPool();
		
		//Le pasamos los mismos contadores a cada tarea
		ex.execute(new Task(loadProcess, processProcess));
		ex.execute(new Task(loadProcess, processProcess));
		ex.execute(new Task(loadProcess, processProcess));
		ex.execute(new Task(loadProcess, processProcess));
		
		try {
			//Espera a que termine el contador
			loadProcess.await();
			//Se puede saegurar la carga de datos
			System.out.println("Ya se han cargado todos los datos");
			
			
			//Espera a que termine el contador
			processProcess.await();
			//Se puede saegurar el procesamiento de datos
			System.out.println("Ya se han procesado todos los datos");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
