package com.tokio.u7;

import java.nio.charset.StandardCharsets;

public class ManejoString {

	public static void main(String[] args) {
		String cadena1=" Hola Mundo! ";
		String cadena2= new String("Hola Andrés Ruiz Peñulea!".getBytes(),StandardCharsets.ISO_8859_1);
		
		System.out.println("cadena 1= "+cadena1+", length= "+cadena1.length());
		System.out.println("cadena 2= "+cadena2+", length= "+cadena2.length());
		
		System.out.println("trim(cadena1)= "+cadena1.trim()+", length= "+cadena1.trim().length());
		
		System.out.println("cadena1.lastIndexOf('a')= "+ cadena1.lastIndexOf('a')+", cadena1.codePointAt('a')= "+cadena1.codePointAt(1));

		System.out.println("+cadena1.toLowerCase()= "+cadena1.toLowerCase());
	}

}
