package com.tokio.observer.concurrencia;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Customer implements Runnable {
	private String name;
	private String email;
	private PropertyChangeSupport change;
	
	public Customer(String name) {
		this.name = name;
		this.change = new PropertyChangeSupport(this);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addChangeListener(PropertyChangeListener listener) {
		change.addPropertyChangeListener(listener);
	}
	
	public void removeChangeListener(PropertyChangeListener listener) {
		change.removePropertyChangeListener(listener);
	}
	
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Customer lanza un pedido: ");
			change.firePropertyChange("nuevo-pedido", false, true);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
			change.firePropertyChange("hacer-algo", null, this);
		}

	}
}
