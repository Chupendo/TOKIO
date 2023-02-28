package com.tokio.observer;

public class PatronObserverRun {
	public static void main(String[] args) {
			//Observable
			Product product = new Product();
			//Observador.
			Provider provider = new Provider();

			//indicamos a product que notifice a provider
			product.addPropertyChangeListener(provider);
			product.setStock(10); //Este cambio no es notificado
			
			product.decreaseStock(2); //Cambio notificado
			
			
	}
}
