package com.tokio.genericos05;

public class NumeriFns<T extends Number> {
	T num;
	
	public NumeriFns(T n){
		this.num = n;
	}
	
	// Detemrina si los valores absolutas son
	//iguales
	boolean absEqual(NumeriFns<? extends Integer> ob) {
		if(Math.abs(this.num.doubleValue())
				== Math.abs(ob.num.doubleValue()))
			return true;
		
		return false;
	}
}
