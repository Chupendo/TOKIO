package com.tokio.colagen;

public interface IQueue<T> {
	// Añadir un elemento
	void put(T t) throws QueueFullException;
	
	// Extraer un elemento
	T get() throws QueueEmpatyException;
}
