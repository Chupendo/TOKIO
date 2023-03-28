package com.tokio.genericos07;

public class Summation {
	private int sum;
	
	public <T extends Number> Summation(T arg){		
		sum = arg.intValue();
	}
	
	public int getSum() {
		return sum;
	} 
}
