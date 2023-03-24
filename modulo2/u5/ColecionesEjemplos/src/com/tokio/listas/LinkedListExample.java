package com.tokio.listas;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
 * Ejemplo de implementación de LinkedList<E>
 * Extiende de AbstractSequentialList<E>
 * Implementa List<E>, Deque<E>, Cloneable, Serializable
 * 
 * Funciones de lista y de cola
 */
public class LinkedListExample {

	public static void main(String[] args) {
		List<Integer> lInt = new LinkedList<>();
		
		Random rd = new Random();
		lInt.addAll(rd.ints(0,1000).limit(20).mapToObj(Integer::new).collect(Collectors.toList())	);
		
		System.out.print("Lista: ");
		lInt.forEach(v->System.out.print(v+", "));
		
		System.out.println();
		System.out.print("Get indes of Object saved: ");
		System.out.println(lInt.lastIndexOf(1));
		System.out.print("Get indes of Object saved: ");
		System.out.println(lInt.lastIndexOf(lInt.get(1)));
		
		//Coge y elimina el elmento de la cabecera
		System.out.println("Poll");
		System.out.println(((LinkedList) lInt).poll());
		
		//Añade al final el emento
		((LinkedList) lInt).offer(200);
		
		System.out.print("Lista: ");
		lInt.forEach(v->System.out.print(v+", "));
	}

}
