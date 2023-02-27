package com.tokio.executor3;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ExecutorTwo {
	private static final Instant INICIO = Instant.now();
	
	public static void main(String[] args) {
		List<Callable<String>> tareas = 
			 Stream.generate(ExecutorTwo::tarea).limit(5).collect(Collectors.toList());
		
		//Creamos un pool de dos tareas
		ExecutorService ex = Executors.newFixedThreadPool(2);
		
		//Enviamos la tarea
		List<Future<String>> futures;
		try {
			futures = ex.invokeAll(tareas);
			
			//Estado de la tarea
			futures.forEach((future)->{
				try {
					Log(future.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Inicia un apagado de tareas
		ex.shutdown();
	}
	
	private static void Log(Object mensaje) {
		System.out.println(String.format("%s [%s] %s", 
			Duration.between(INICIO, Instant.now()), Thread.currentThread().getName(), mensaje.toString()));
	}
	
	public static Callable<String> tarea(){
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
		
		return tarea;
	}
}
