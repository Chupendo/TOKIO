package com.tokio.colagen;

// Excepcion para colas vacias
public class QueueEmpatyException extends Exception {

	@Override
	public String toString() {
		return "\nQueue is empty.";
	}
}
