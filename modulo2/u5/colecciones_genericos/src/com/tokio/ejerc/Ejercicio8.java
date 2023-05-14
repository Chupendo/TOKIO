package com.tokio.ejerc;

public class Ejercicio8 {
	
	public static void main(String[] args) {

		Gen<Integer> gen = new Gen<Integer>(Integer.valueOf(9));
		Integer e = gen.MyGen(10);
	}
}
