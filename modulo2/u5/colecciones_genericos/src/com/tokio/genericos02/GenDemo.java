package com.tokio.genericos02;

public class GenDemo {

	public static void main(String[] args) {
		TwoGen<Integer, String> tgObj = 
				new TwoGen<Integer, String>(88, "Generics");
		
		// Mostrar los tipos
		tgObj.showType();
		
		int t = tgObj.getObj1();
		String v = tgObj.getObj2();
		System.out.println("t= "+t+", v= "+v);
	}
}
