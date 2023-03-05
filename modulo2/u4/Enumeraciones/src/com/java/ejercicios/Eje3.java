package com.java.ejercicios;


public class Eje3 {
	enum Tools{
		SCREWDRIVER, WRENH, HAMMER, PLIERS
	};
	
	public static void main(String[] args) {
		
		Tools[] tools = Tools.values();
		for (Tools tool : tools) {
			System.out.println(tool.ordinal()+", "+tool.name());
		}

	}
}
