package com.tokio.executor1;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorOne {
	private static final Instant INICIO = Instant.now();
	
	public static void main(String[] args) {
		Runnable tarea= ()->{
			Log("Inicio de la tarea");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Log("Finaliza la tarea");
		};
		
		//Creamos un pool de pisicinas con hilo único
		ExecutorService ex = Executors.newSingleThreadExecutor();
		
		//Enviamos la tarea
		ex.submit(tarea);
		//Inicia un apagado de tareas
		ex.shutdown();
		
		//ex no acepta mas tareas tras shutdown
		//ex.submit(tarea); //!EROR¡
	}
	
	
	private static void Log(Object mensaje) {
		System.out.println(String.format("%s [%s] %s", 
			Duration.between(INICIO, Instant.now()), Thread.currentThread().getName(), mensaje.toString()));
	}
}
