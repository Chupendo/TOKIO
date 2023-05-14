package com.tokio.ejerc;

public interface IGenIF<T, V extends T> {

	void show(T t, V v);
}
