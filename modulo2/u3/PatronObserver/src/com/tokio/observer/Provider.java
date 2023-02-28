package com.tokio.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//Clase observador (acuta en cosecuencia al cambio)
public class Provider implements PropertyChangeListener{
	private String name;
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("stock")) {
			System.out.print("El stock ha a bajado. ");
			System.out.print("Valor antiguo: "+evt.getOldValue());
			System.out.println(" Valor nuevo: "+evt.getNewValue());
		}		
	}
}
