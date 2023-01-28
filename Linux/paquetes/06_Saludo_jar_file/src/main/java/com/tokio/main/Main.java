package com.tokio.main;

import org.apache.commons.lang3.StringUtils;

import com.tokio.fichero.Read;

public class Main{
	public static void main(String[] args) {
		Read r = new Read();

		System.out.println("Read: "+r.getText());
		System.out.println("Read: "+StringUtils.upperCase(r.getText()));
		
	}	
}