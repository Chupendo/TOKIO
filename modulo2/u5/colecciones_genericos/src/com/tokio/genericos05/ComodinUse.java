package com.tokio.genericos05;

public class ComodinUse {

	public static void main(String[] args) {
		NumeriFns<Integer> obj1 = new NumeriFns<Integer>(88);
		NumeriFns<Double> obj2 = new NumeriFns<Double>(-88.00);
		NumeriFns<Integer> obj3 = new NumeriFns<Integer>(88);
		
		System.out.println(obj1.absEqual(obj3));
		
		//Error, obj1 no es de tipo Integer
		//System.out.println(obj1.absEqual(obj2)); 
	}
}


