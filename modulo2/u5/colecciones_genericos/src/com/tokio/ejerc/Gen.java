package com.tokio.ejerc;

public class Gen<T>{
	T data;
	public Gen(T d) {
		this.data = d;
	}
	public <T> T MyGen(T d) {
		System.out.println(String.format("%s %s",this.data,d));
		return  d;
	}
}