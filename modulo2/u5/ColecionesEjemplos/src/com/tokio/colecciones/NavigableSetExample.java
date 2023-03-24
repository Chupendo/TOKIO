package com.tokio.colecciones;

import java.util.NavigableSet;
import java.util.TreeSet;

/*
 * Interface NavigableSet<E>
 * Extiende de Collection<E>, Iterable<E>, Set<E>, SortedSet<E>
 * Implementaciones: ConcurrentSkipListSet, TreeSet
 */
public class NavigableSetExample {

	public static void main(String[] args) {
		NavigableSet<Integer> nSet = new TreeSet<>();
		nSet.add(1);
		nSet.add(2);
		nSet.add(3);
		System.out.println("First: "+nSet.pollFirst());
		System.out.println("Last: "+nSet.pollLast());	
	}
}
