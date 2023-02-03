package com.tokio.readChar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsole {

	public static void main(String[] args) {
		
		//Read with system
		
		char c;
		StringBuilder sb = new StringBuilder();
		try {
			//Lee un byte
			do {
			System.out.print("Inserte un digito (. para salir): ");
			c = (char) System.in.read();
			sb.append(c);
			}while(c!='.');
			
			System.out.println(sb.toString());
			
			//Buffer read
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Inserte your name: ");
			br.readLine(); //crean buffer
			String line = br.readLine();
			System.out.println("line= "+line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
