package com.tokio.listas;

import java.util.Enumeration;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		Vector<Integer> vInt = new Vector<>();
		
		System.out.println("Capacidad (default): "+vInt.capacity());
		try {
			//Añade en la posicion 2 el elemento 1
			vInt.add(2,1);
		}catch(ArrayIndexOutOfBoundsException ex) {
			//Si hay error java.lang.ArrayIndexOutOfBoundsException: 2 > 0
			ex.printStackTrace();
		}
		
		vInt.add(1);
		vInt.add(2);
			
		Enumeration<Integer> enumInt =vInt.elements();
		System.out.println(enumInt.nextElement());
	}
}
