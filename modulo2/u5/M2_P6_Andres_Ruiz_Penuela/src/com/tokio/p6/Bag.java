package com.tokio.p6;
import java.util.Random;
import java.util.stream.Stream;

public class Bag<T> implements Operations<T> {
	private T[] data;
	private int size = 0;

	public Bag() {
		this.data = (T[]) new Object[1];
		this.size = 0;
	}

	@Override
	public void add(T elem) {
		if (this.data == null) {
			this.data = (T[]) new Object[1];
		} else {
			if (size == this.data.length) {
				T[] aux = this.data;
				this.data = (T[]) new Object[this.data.length + 1];

				for (int i = 0; i < aux.length; i++) {
					this.data[i] = aux[i];
				}
			}

		}

		this.data[size] = elem;
		size++;
	}

	@Override
	public void clear() {
		this.data = null;
		this.size = 0;
	}

	@Override
	public boolean contians(T elem) {
		boolean is = false;
		int i = 0;
		if (!this.isEmpaty()) {
			
			while (!is && i < size) {
				if (this.data[i] == elem) {
					is = true;
				}
				i++;
			}
		}

		return is;
	}

	@Override
	public boolean isEmpaty() {
		return (this.data != null && this.data.length != 0 && size != 0) ? false : true;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public T extract() {
		if (this.isEmpaty()) {
			return null;
		}
		Random rd = new Random();
		int pos = rd.nextInt(size);
		T elem = this.data[pos];

		for (int i = pos; i < size - 1; i++) {
			this.data[i] = this.data[i + 1];
		}
		size--;
		return elem;
	}

	public void show() {
		System.out.println("SIZE= " + size);
		for (int i = 0; i < size; i++) {
			System.out.println("pos: " + i + ", elem: " + this.data[i]);
		}
	}
}

