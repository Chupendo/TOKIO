package com.tokio.observer.concurrencia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

	public static void main(String[] args) {	
		//Observable
		Customer customer = new Customer("cliente1");
		//Observadores
		Provider provider1 = new Provider();
		Provider provider2 = new Provider();
		
		//Indicmoas el observable los observadores
		customer.addChangeListener(provider1);
		customer.addChangeListener(provider2);
		
		//Lanzamos las tareas
		ExecutorService ex = Executors.newCachedThreadPool();
		ex.execute(customer);
		ex.execute(provider1);

	}
}
