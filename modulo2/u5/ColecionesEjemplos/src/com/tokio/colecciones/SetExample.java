package com.tokio.colecciones;

import java.util.HashSet;
import java.util.Set;

/*
 * Set<E>>
 * Extiende de Collection<E>, Iterable<E>
 * Subinterfaces: NavigableSet<E>, SortedSet<E>
 * Implementaciones: AbstractSet, ConcurrentHashMap.KeySetView, ConcurrentSkipListSet, CopyOnWriteArraySet, EnumSet, HashSet, JobStateReasons, LinkedHashSet, TreeSet
 */
public class SetExample {

	public static void main(String[] args) {
		Set<Integer> set = new  HashSet<>();
		
		set.add(1);
		set.add(2);
		
		System.out.println("1 in set? "+set.contains(1));

	}

}
