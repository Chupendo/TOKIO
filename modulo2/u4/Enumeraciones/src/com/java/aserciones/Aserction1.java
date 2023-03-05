package com.java.aserciones;


public class Aserction1 {
	
	public static void main(String[] args) {	
		//String[] names = {"John", "Mary", "David"};
		String[] names = null;
		
		assert names==null || names.length == 2 : String.format("No cumple la longitud %d", names==null?0:names.length);

        System.out.println("There are "+names.length + "  names in an array");
	}
}
