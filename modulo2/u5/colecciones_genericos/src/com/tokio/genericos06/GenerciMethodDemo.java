package com.tokio.genericos06;

public class GenerciMethodDemo {
	
	public static <T extends Comparable<T>, V extends T> boolean arraysEqual(T[] x, V[] y) {
		//Si la longitud es diferente, las matrices difiere
		if(x.length != y.length) return false;
		
		for(int i=0;i<x.length;i++)
			if(x[i]!=y[i]) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		Integer num1[] = {1,2,3,4,5,6,7};
		Integer num2[] = {1,2,3,4,5,6,8};
		Integer num3[] = {1,2,3,4,5,6,9,10};
		
		System.out.println("num1 == num1?: "+arraysEqual(num1, num1));
		System.out.println("num1 == num2?: "+arraysEqual(num1, num2));
		System.out.println("num1 == num3?: "+arraysEqual(num1, num3));
		
	}
}
