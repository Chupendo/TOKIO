package com.tokio.ambiguo;

// Clase generica ambigua
public class GenAm<T, V>  {

	private T t;
	private V v;
	
	public void set(T t) {
		this.t = t;
	}
	
	public void set(V v) {
		this.v = v;
	}
}
