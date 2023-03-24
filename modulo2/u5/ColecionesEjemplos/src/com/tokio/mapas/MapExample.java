package com.tokio.mapas;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/*
 * Interface Map<K,V>
 * Subinterfaces Bindings, ConcurrentMap<K,V>, ConcurrentNavigableMap<K,V>, LogicalMessageContext, MessageContext, NavigableMap<K,V>, SOAPMessageContext, SortedMap<K,V>
 * Implementaciones AbstractMap, Attributes, AuthProvider, ConcurrentHashMap, ConcurrentSkipListMap, EnumMap, HashMap, Hashtable, IdentityHashMap, LinkedHashMap, PrinterStateReasons, Properties, Provider, RenderingHints, SimpleBindings, TabularDataSupport, TreeMap, UIDefaults, WeakHashMap
 */
public class MapExample {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(4, "d");
		map.put(3, "c");
		
		
		for(Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("k: "+entry.getKey()+", v: "+entry.getValue());
		}
		
		System.out.println("key 1: "+map.get(1));
		System.out.println("key 26: "+map.get(26));
	}

}
