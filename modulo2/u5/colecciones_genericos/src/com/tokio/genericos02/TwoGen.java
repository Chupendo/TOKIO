package com.tokio.genericos02;

public class TwoGen<T, V> {
	T obj1;
	V obj2;
	public TwoGen(T obj1,V obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	//Mostrar los tipos de datos
	public void showType() {
		System.out.println("Type of T is "+obj1.getClass().getName());
		System.out.println("Type of V is "+obj2.getClass().getName());
	}
	
	public T getObj1() {
		return obj1;
	}
	
	public V getObj2() {
		return obj2;
	}
	
	public void setObj1(T obj1) {
		this.obj1 = obj1;
	}
	
	public void setObj2(V obj2) {
		this.obj2 = obj2;
	}
}
