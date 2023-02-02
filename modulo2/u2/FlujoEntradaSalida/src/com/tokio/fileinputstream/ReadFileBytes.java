package com.tokio.fileinputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileBytes {
	private static String path = "C:\\Users\\andre\\eclipse-workspace\\TOKIO\\modulo2\\u2\\FlujoEntradaSalida\\src\\resources\\";

	public static void main(String[] args) {
		FileInputStream fl = null;
		try {
			fl = new FileInputStream(path + "file.txt");
			
			int i;
			do {
				i = fl.read();
				System.out.print((char) i);
			} while (i != -1);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fl!=null)
				try {
					fl.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
