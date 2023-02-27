package com.tokio.ejercicio12;

public class Queue {
	int []queue;
	private int tope;
	int index;
	
	public Queue(int tope) {
		this.tope=tope;
		this.index=-1;
		queue = new int[tope];
	}
	
	public void add(int elem) {
		if(index==tope) {
			throw new IndexOutOfBoundsException();
		}else if(index<0) {
			index=0;
		}
		
		queue[index]=elem;
		index++;
	}
	
	public int get() {
		if(index<0) {
			throw new IndexOutOfBoundsException();
		}
		index--;
		return queue[index];
	}
	
	public int getTope() {
		return this.tope;
	}
}
