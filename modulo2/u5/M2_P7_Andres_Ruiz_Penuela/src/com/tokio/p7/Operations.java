package com.tokio.p7;

public interface Operations<T> {
	void add(T elem);
	void clear();
	boolean contians(T elem);
	boolean isEmpaty();
	int size();
	T extract();
}
