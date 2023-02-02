package com.tokio.fileoutputstream;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriterFileBytes {
	private static String path = "C:\\Users\\andre\\eclipse-workspace\\TOKIO\\modulo2\\u2\\FlujoEntradaSalida\\src\\resources\\";

	public static void main(String[] args) {
		FileOutputStream fo = null;
		
		try {
			fo = new FileOutputStream(path+"file.txt",true);
			
			String texto = "Agrego este testo\ndesde Java.";
			byte[] copy = texto.getBytes();
			for(int i =0;i<texto.length();i++) {
				fo.write(copy[i]);
			}
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
