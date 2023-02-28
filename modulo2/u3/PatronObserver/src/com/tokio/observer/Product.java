package com.tokio.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

//Clase observable  (LA QUE ESTA SIENDO OBSERVADA)
public class Product {

	private String name;
	private int stock;
	private PropertyChangeSupport change;
	
	public Product() {
		this.change = new PropertyChangeSupport(this);
	}

	//agrega el observador
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		change.addPropertyChangeListener(listener);
	}
	
	//elimina el observador
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		change.removePropertyChangeListener(listener);
	}
	
	//realiza un cambio y no lo notifica
	public void decreaseStock(int quantity) {
		change.firePropertyChange("stock", stock, (stock-quantity));
		stock -=quantity;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
