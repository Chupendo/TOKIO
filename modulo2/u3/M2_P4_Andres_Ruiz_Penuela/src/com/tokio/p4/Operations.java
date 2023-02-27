package com.tokio.p4;

import java.util.List;

public class Operations {

	//Añade un elemento a la lista
	public void add(List<Integer> lNums,int elem) {
		lNums.add(elem);
	}
	
	//Devuelve u elimina el ultimo elemnto de la lista
	public int get(List<Integer> lNums) {
		return lNums.remove(lNums.size()-1);
	}
}
