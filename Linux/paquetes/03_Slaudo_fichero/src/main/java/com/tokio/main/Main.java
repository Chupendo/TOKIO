package com.tokio.main;

import com.tokio.fichero.Read;

public class Main{
	public static void main(String[] args) {
		Read r = new Read();

		System.out.println("Read: "+r.getText());
	}	
}