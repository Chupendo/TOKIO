package com.tokio.evaluacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test1 {

	public static void main(String[] args) {
		try {
			   BufferedReader ficheroEntrada = new BufferedReader(
			      new FileReader(new File("Fichero.txt"));
			   String linea = null;
			   while((linea = ficheroEntrada.readLine())!= null {
			      System.out.println(linea);
			   }
	}
s}
