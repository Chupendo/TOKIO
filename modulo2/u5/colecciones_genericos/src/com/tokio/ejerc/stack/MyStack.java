package com.tokio.ejerc.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

public class MyStack<T> implements IGenStack<T>, Iterable<T>{
	T[] t;
	private int size, climb;

	public MyStack(int size) {
		this.size = size;
		this.t = (T[]) new Object[size];
		this.climb=-1;
	}
	@Override
	public void push(T elem) throws StackOverflowError {
		if(this.climb<this.size) {
			this.climb++;
			this.t[this.climb]=elem;
		}else {
			throw new StackOverflowError(); 
		}
	}

	@Override
	public T pop() throws EmptyStackException{
		T elem = null;
		if(this.climb>-1) {
			elem = this.t[this.climb];
			this.climb--;
			
		}else {
			throw new EmptyStackException();
		}
		return (T) elem;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {
			int pos = 0;
			@Override
			public boolean hasNext() {
				return this.pos<size;
			}
			@Override
			public T next() {
				T elem = null;
				if(hasNext()) {
					elem = (T) t[this.pos];
					this.pos++;
				}
				return elem;
			}
		};
	}

}
