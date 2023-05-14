package com.tokio.ejerc;

public class GenIFImpl<T,V extends T> implements IGenIF<T, V> {

	@Override
	public void show(T t, V v) {
		System.out.println("T.getClass: "+t.getClass());
		System.out.println("V.getClass: "+v.getClass());
	}
}
