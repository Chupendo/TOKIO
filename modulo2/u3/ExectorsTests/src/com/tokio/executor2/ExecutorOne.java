package com.tokio.executor2;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class ExecutorOne {
	private static final Instant INICIO = Instant.now();
	
	public static void main(String[] args) {
		Callable<String> tarea= ()->{
			Log("Inicio de la tarea");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Log("Finaliza la tarea");
			return "Resultado de la tarea";
		};
		
		//Creamos un pool de pisicinas con hilo único
		ExecutorService ex = Executors.newSingleThreadExecutor();
		
		//Enviamos la tarea
		Future<String> resultado = ex.submit(tarea);
		
		//Estado de la tarea
		Log(resultado.isDone());
		//Espera a que finalice la tarea para coger el
		//resultado
		try {
			Log(resultado.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		//Resultado de la tarea
		Log(resultado.isDone());
		//Inicia un apagado de tareas
		ex.shutdown();
	}
	
	private static void Log(Object mensaje) {
		System.out.println(String.format("%s [%s] %s", 
			Duration.between(INICIO, Instant.now()), Thread.currentThread().getName(), mensaje.toString()));
	}
}
