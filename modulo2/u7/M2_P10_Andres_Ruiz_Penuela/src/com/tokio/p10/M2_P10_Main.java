package com.tokio.p10;

public class M2_P10_Main {

	public static void main(String[] args) {
		System.out.println("---------\nStringBuilder\n---------");
		UsoStringBuilder();
		System.out.println("---------\nStringBuffer\n---------");
		UsoStringBuffer();
	}
	
	public static void UsoStringBuilder(){
		StringBuilder cadena = new StringBuilder("Hay coches");
		System.out.println("cadena= "+cadena.toString()
				+"\n\tcapacidad= "+cadena.capacity()
				+"\nl\tongitud= "+cadena.length());
		
		cadena.append(" en el desguace");
		System.out.println("cadena= "+cadena.toString()
			+"\n\tcapacidad= "+cadena.capacity()
			+"\n\tlongitud= "+cadena.length());
		
		int n = 1000;
		cadena.insert(10, String.format(" hay mas de %d coches", n));
		System.out.println("cadena= "+cadena.toString()
			+"\n\tcapacidad= "+cadena.capacity()
			+"\n\tlongitud= "+cadena.length());
		
		String lastFourDigit = cadena.substring(cadena.length()-4);
		System.out.println("cadena= "+lastFourDigit
				+"\n\tlongitud= "+lastFourDigit.length());
	}

	public static void UsoStringBuffer(){
		StringBuffer cadena = new StringBuffer("Hay coches");
		System.out.println("cadena= "+cadena.toString()
				+"\n\tcapacidad= "+cadena.capacity()
				+"\nl\tongitud= "+cadena.length());
		
		cadena.append(" en el desguace");
		System.out.println("cadena= "+cadena.toString()
			+"\n\tcapacidad= "+cadena.capacity()
			+"\n\tlongitud= "+cadena.length());
		
		int n = 1000;
		cadena.insert(10, String.format(" hay mas de %d coches", n));
		System.out.println("cadena= "+cadena.toString()
			+"\n\tcapacidad= "+cadena.capacity()
			+"\n\tlongitud= "+cadena.length());
		
		String lastFourDigit = cadena.substring(cadena.length()-4);
		System.out.println("cadena= "+lastFourDigit
				+"\n\tlongitud= "+lastFourDigit.length());
	}
}
