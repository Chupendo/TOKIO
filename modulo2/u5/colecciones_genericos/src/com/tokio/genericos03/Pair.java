package com.tokio.genericos03;

/**
 * PARAMETROS DE TIPO VINCULADOS
 * @author andre
 *
 * @param <T>
 * @param <V extends T>
 */
public class Pair<T, V extends T> {
	T first;
	V second;
	
	Pair(T a, V b){
		first = a ;
		second = b;
	}
}
