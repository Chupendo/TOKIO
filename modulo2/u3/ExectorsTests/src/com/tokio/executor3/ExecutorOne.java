package com.tokio.executor3;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecutorOne {
	private static final Instant INICIO = Instant.now();
	private static int contadorTareas = 1;
	
	public static void main(String[] args) {
		List<Callable<String>> tareas = Stream.generate(ExecutorOne::tarea).limit(5).collect(Collectors.toList());

		// Creamos un pool de dos tareas
		ExecutorService ex = Executors.newFixedThreadPool(2);

		// Enviamos la tarea
		try {
			String resultadoAny = ex.invokeAny(tareas);
			Log(resultadoAny);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Inicia un apagado de tareas
		ex.shutdown();
	}

	private static void Log(Object mensaje) {
		System.out.println(String.format("%s [%s] %s", Duration.between(INICIO, Instant.now()),
				Thread.currentThread().getName(), mensaje.toString()));
	}

	public static Callable<String> tarea() {
		int numeroTarea = contadorTareas++;

		return () -> {
			Log("Inicio de la tarea " + numeroTarea);
			try {
				TimeUnit.SECONDS.sleep(5);
				Log("Finaliza la tarea " + numeroTarea);
				return "resultado de la tarea " + numeroTarea;
			} catch (InterruptedException e) {
				Log("sleep ha sido interrumpido en tarea " + numeroTarea);
				return null;
			}
		};
	}
}
