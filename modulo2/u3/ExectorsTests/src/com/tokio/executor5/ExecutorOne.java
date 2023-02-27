package com.tokio.executor5;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorOne {

	public static void main(String[] args) {
		//El contador empieza de 4
		CyclicBarrier dataProcess = new CyclicBarrier(4);
		
		
		ExecutorService ex = Executors.newCachedThreadPool();
		
		//Le pasamos los mismos contadores a cada tarea
		ex.execute(new Task(dataProcess));
		ex.execute(new Task(dataProcess));
		ex.execute(new Task(dataProcess));
		ex.execute(new Task(dataProcess));
		
		//Espera a que termine el contador
		while(dataProcess.isBroken()) {
			System.out.println("Cargando datos . . .");
		}
		//Se puede saegurar la carga de datos
		System.out.println("Ya se han cargado todos los datos");

		//Espera a que termine el contador
		//dataProcess.reset();
		//Se puede saegurar el procesamiento de datos
		System.out.println("Ya se han procesado todos los datos");
	}
}
