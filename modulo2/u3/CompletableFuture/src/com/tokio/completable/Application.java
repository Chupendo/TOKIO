package com.tokio.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class Application {

	public static void main(String[] args) {
		//Sin return
		CompletableFuture.runAsync(()->{System.out.println("Hola");}, Executors.newCachedThreadPool())
			.whenComplete((nothing,error)->fin());
		
		//Con return
		CompletableFuture.supplyAsync(()->{return "Hola ";})
		.thenAccept(System.out::print)
		.whenComplete((nothing,error)->fin());
	}
	
	public static void fin() {
		System.out.println("Fin.");
	}
}
