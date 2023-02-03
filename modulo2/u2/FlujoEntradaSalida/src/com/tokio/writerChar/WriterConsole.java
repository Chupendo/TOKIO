package com.tokio.writerChar;

import java.io.PrintWriter;

public class WriterConsole {

	public static void main(String[] args) {
		
		PrintWriter pw = new PrintWriter(System.out,true);
		
		double d = 232.2;
		pw.format("Hola {} %s ", d);
		String s = String.format("hola {}", d);

	}
}
