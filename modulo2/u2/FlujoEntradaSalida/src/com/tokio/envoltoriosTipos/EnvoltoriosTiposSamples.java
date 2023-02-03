package com.tokio.envoltoriosTipos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class EnvoltoriosTiposSamples {

	public static void main(String[] args) {

		// Escritura flujo bytes
		try (FileOutputStream fo = new FileOutputStream("envoltorios.txt")) {
			fo.write("hola".getBytes());
			fo.write("\n".getBytes());
			fo.write("12".getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Lectura flujo caracteres
		try (FileInputStream fi = new FileInputStream("envoltorios.txt")) {
			int i = 0;
			do {
				i = fi.read();
				if (i != -1)
					System.out.print((char) i);
			} while (i != -1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("=====================");
		// Lectura flujo caracteres
		try (FileReader fr = new FileReader("envoltorios.txt"); 
				BufferedReader bf = new BufferedReader(fr)) {

			String data;
			do {
				data = bf.readLine();
				if (data != null) {
					try {
						Integer.parseInt(data);
						System.out.println(data + " es un tipo entero");
					} catch (NumberFormatException e) {
						System.err.println(e.getMessage() + " no es un tipo entero");
					}
				}

			} while (data != null);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Escribir en un fichero con flujo de caracteres
		try(FileWriter fw = new FileWriter("envoltorios.txt", true);
				BufferedWriter bw = new BufferedWriter(fw)){
				
				bw.write("hola 2");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
