package com.tokio.p6;

public interface Operations<T> {
	void add(T elem);
	void clear();
	boolean contians(T elem);
	boolean isEmpaty();
	int size();
	T extract();
}
