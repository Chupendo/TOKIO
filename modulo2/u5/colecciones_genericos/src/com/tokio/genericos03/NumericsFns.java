package com.tokio.genericos03;

/**
 * NumericsFns es una clase generica
 * con un parametro tipo T que ha de ser
 * de tipo Number
 * 
 * @author andre
 * @param <T extends Number>
 */
public class NumericsFns<T extends Number> {

	T num;
	
	//Construcutro con refernica
	public NumericsFns(T n) {
		this.num = n;
	}
	
	//Devuelve el recíproco
	double reciprocal() {
		return 1 / num.doubleValue();
	}
	
	// Devuelve el componente fraccional
	double fraction() {
		return num.doubleValue() - num.intValue();
	}
}
