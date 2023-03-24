package com.tokio.genericos01;

import java.util.HashSet;
import java.util.Set;

public class GenDemo {

	public static void main(String[] args) {
		Gen<Integer> iObj = new Gen<Integer>(88);
		System.out.println("Class: "+ iObj.showType());
		System.out.println("Value: "+ iObj.getObj());
		
		Gen<String> strObj = new Gen<String>("Hola");
		System.out.println("Class: "+ strObj.showType());
		System.out.println("Value: "+ strObj.getObj());
		
		String[] data = {"Hola","Adios"};
		Gen<String[]> matrizSTRtrObj = new Gen<String[]>(data);
		System.out.println("Class: "+ matrizSTRtrObj.showType());
		System.out.println("Value: "+ matrizSTRtrObj.getObj());
				
		Gen<Set<Integer>> setObj = new Gen<Set<Integer>>(new HashSet<>());
		System.out.println("Class: "+ setObj.showType());
		System.out.println("Value: "+ setObj.getObj());

	}
}
