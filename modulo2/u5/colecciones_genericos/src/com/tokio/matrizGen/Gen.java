package com.tokio.matrizGen;

public class Gen<T> {
	T ob;
	
	T[] v; //correcto
	
	public Gen(T o, T[] nums) {
		ob = o;
		
		// Incorrecto, 
		// no se puede crear una matriz de tipos
		//v = new T[10] 
		
		// Correcto
		v = nums;
	}
	
	public static void main(String[] args) {
		// Incorrecto,
		// no se puede crear una matriz de referneica generica 
		// de tipo concreto
		//Gen<Integer>[] vGen = new Gen<Integer>[10];
		
		// Correcto
		Gen<?>[] vGen = new Gen<?>[10];
	}
}
