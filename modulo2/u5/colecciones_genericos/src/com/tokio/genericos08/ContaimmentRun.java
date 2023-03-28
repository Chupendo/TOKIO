package com.tokio.genericos08;

interface Contaimment<T,V> {
	//El metodo contains comprueba si el objeto
	//se encuentra dentro de otro objeto
	//que implmenta Contaimment
	boolean contains(T o); 
}

public class ContaimmentRun<T,V> implements Contaimment<T,V>{
	T[] nums;
	
	public ContaimmentRun(T[] o) {
		nums = o;
	}
	
	
	@Override
	public boolean contains(T o) {
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==o) return true;
		}
		return false;
	}
}