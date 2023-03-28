package com.tokio.colagen;

//Errores para colas llenas
public class QueueFullException extends Exception {
	private int size;
	
	public QueueFullException(int s) {
		this.size = s;
	}
	
	@Override
	public String toString() {
		return "\nQueue is full. Maximum size is "+ size;
	}
}
