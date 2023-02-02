package com.tokio.fileaccesrandom;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileAccessRandom {

	public static void main(String[] args) {
		String path = "C:\\Users\\andre\\eclipse-workspace\\TOKIO\\modulo2\\u2\\FlujoEntradaSalida\\src\\resources\\";

		// Leer un archivo
		try (RandomAccessFile file = new RandomAccessFile(path + "file.txt", "rw")) {
			file.seek(3); // Leemos desde la posicon 3
			int x;
			do {
				x = file.read();
				if (x != -1)
					System.out.print((char) x);
			} while (x != -1);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\n===================");
		double data[] = { 19.4, 10.1, 123.54, 33.0 , 87.9, 74.25 };
		double d;
		//Open file else create new file in C:\\Users\\andre\\eclipse-workspace\\TOKIO\\modulo2\\u2\\FlujoEntradaSalida
		try (RandomAccessFile file = new RandomAccessFile("random.dat", "rw")) {
			file.seek(0);
			//Esciribmros valores en el fichero
			for(int i=0;i<data.length;i++) {
				file.writeDouble(data[i]);
			}
			System.out.println("Length: "+file.length());
			//Leer los valroes
			file.seek(0); //poscion 0
			d=file.readDouble();
			System.out.println("First value is = "+d);
			
			file.seek(8); //1 Byte son 8 btis --> 1 Dobule son 64 bits 
						 //por tanto se desplaza el puntero en 64/8 = 8 bytes
			d=file.readDouble();
			System.out.println("Second value is = "+d);
			
			file.seek(8*3); //Byte 24
			d=file.readDouble();
			System.out.println("Four value is = "+d);
			
			file.seek(8*5); //Byte 24
			d=file.readDouble();
			System.out.println("Last value is = "+d);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
