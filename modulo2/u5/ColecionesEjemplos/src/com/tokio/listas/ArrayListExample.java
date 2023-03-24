package com.tokio.listas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Ejemplo de implementaicón de ArrayList<E>
 * Extiende de AbstracList<E>
 * Implementa: List<E>, RandomAccess, Cloneable, Serializable
 */
public class ArrayListExample {

	public static void main(String[] args) {
		List<Integer> lInt = new ArrayList<>();
		
		lInt.add(1);
		lInt.addAll(IntStream.range(1, 1000).limit(5).mapToObj(Integer::new).collect(Collectors.toList()));
		
		System.out.print("Lista: ");
		lInt.forEach(value->
		System.out.print(value+", "));//Lista: 1, 1, 2, 3, 4, 5,
		
		//Uso de iteradores
		Iterator<Integer> it = lInt.iterator();
		
		System.out.print("Lista: ");
		while(it.hasNext()) {
			System.out.print(it.next()+", ");
		}//Lista: 1, 1, 2, 3, 4, 5,
		
		System.out.print("Lista: ");
		while(it.hasNext()) {
			System.out.print(it.next()+", ");
		}//Lista: 

		//fin de uso de iteradores
		
		//Get elemento by index
		System.out.print("Get element:");
		System.out.println(lInt.get(1));
		
		lInt.sort(Comparator.reverseOrder());
		System.out.print("Lista: ");
		lInt.forEach(value->
		System.out.print(value+", "));//ista: 5, 4, 3, 2, 1, 1, 
	}

}
