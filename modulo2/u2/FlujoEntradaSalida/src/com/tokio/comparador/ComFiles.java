package com.tokio.comparador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Ejercicio que compara dos archvios
 * 
 * @author andre
 *
 */
public class ComFiles {
	private static String path = "C:\\Users\\andre\\eclipse-workspace\\TOKIO\\modulo2\\u2\\FlujoEntradaSalida\\src\\resources\\";

	public static void main(String[] args) {
		int i=0,j=0;
		
		try (FileInputStream fin1 = new FileInputStream(path+"file1.txt");
				FileInputStream fin2 = new FileInputStream(path+"file2.txt")
			){
			//Comparar el contenido
			do {
				i = fin1.read();
				j = fin2.read();
				if(i!=j) {
					break;
				}
			}while(i!=-1&&j!=-1);
			
			if(i!=j) {
				System.out.println("Files differ.");
			}else {
				System.out.println("Files are the same.");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
