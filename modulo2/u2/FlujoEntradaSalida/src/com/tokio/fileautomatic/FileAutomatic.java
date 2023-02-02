package com.tokio.fileautomatic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileAutomatic {
	private static String path = "C:\\Users\\andre\\eclipse-workspace\\TOKIO\\modulo2\\u2\\FlujoEntradaSalida\\src\\resources\\";

	public static void main(String[] args) {
		
		//Opcion 1
		System.out.println("opiotn 1 try(...){}");
		final FileInputStream fin;
		try {
			fin = new FileInputStream(path+"file.txt");
			
			try(fin){
				int digt;
				do {
					digt = fin.read();
					System.out.print((char)digt);
				}while(digt!=-1);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		//Opcion 2
		System.out.println("opiotn 2 try(...){}");
		try(FileInputStream fin2 = new FileInputStream(path+"file.txt")){
			int digt;
			do {
				digt = fin2.read();
				System.out.print((char)digt);
			}while(digt!=-1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
