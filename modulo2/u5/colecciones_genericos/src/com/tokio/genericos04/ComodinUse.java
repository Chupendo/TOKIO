package com.tokio.genericos04;

public class ComodinUse {

	public static void main(String[] args) {
		NumeriFns<Integer> obj1 = new NumeriFns<Integer>(88);
		NumeriFns<Double> obj2 = new NumeriFns<Double>(-88.00);
		
		System.out.println(obj1.absEqual(obj2));
	}

}


