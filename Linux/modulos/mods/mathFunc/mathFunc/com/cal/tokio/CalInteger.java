package com.cal.tokio;

public class CalInteger {

	public static int plus(int a,int b) {
		return a+b;
	}
	
	public static int minus(int a,int b) {
		return a-b;
	}
	
	public static int div(int a,int b) {
		return a/b;
	}
	
	public static int mod(int a,int b) {
		return a%b;
	}
	
	public static int power(int a,int b) {
		int result = 1;
		for(int i=0;i<b;i++) {
			result *=a; 
		}
		return result;
	}
}
