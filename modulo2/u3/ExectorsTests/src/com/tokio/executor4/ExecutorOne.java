package com.tokio.executor4;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorOne {
	private static final Instant INICIO = Instant.now();
	private static int contadorTareas = 1;

	public static void main(String[] args) {

		Runnable tarea = () -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Log("Ejecución de tarea");
		};

		// Creamos un pool de dos tareas
		ScheduledExecutorService schedulerExecutor = Executors.newScheduledThreadPool(1);

		// Enviamos la tarea

		// Retardo inicial de 3 seugndos
		schedulerExecutor.schedule(tarea, 3, TimeUnit.SECONDS);
		
		// Retardo inicial de 2 segudnas, y luego lanzar cada segundo
		schedulerExecutor.scheduleAtFixedRate(tarea,2,1,TimeUnit.SECONDS);
		
		// Retardo inicial de 2 segudnas, y luego lanzar cada segundo 
		schedulerExecutor.scheduleWithFixedDelay(tarea,2,1,TimeUnit.SECONDS);
		
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Inicia un apagado de tareas
		schedulerExecutor.shutdown();
	}

	private static void Log(Object mensaje) {
		System.out.println(String.format("%s [%s] %s", Duration.between(INICIO, Instant.now()),
				Thread.currentThread().getName(), mensaje.toString()));
	}
}
