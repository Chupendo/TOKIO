package com.tokio.observer.concurrencia;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Provider implements PropertyChangeListener, Runnable {
	private String name;

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String evtName = evt.getPropertyName();
		switch (evtName) {
		case "nuevo-pedido":
			System.out.println("Cliente hizo un nuevo pedido");
			break;
		case "hacer-algo":
			System.out.println("Cliente hizo algo");
			Customer customer = (Customer) evt.getNewValue();
			System.out.println(customer.getName());
			break;
		}

	}

	@Override
	public void run() {
		while(true) {
			System.out.println("Soy el Provider");
			try {
				Thread.sleep(200);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
	}
}
