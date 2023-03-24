package com.tokio.casopractico;

import java.util.LinkedList;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class clase5 {

	public static void main(String[] args) {
		NavigableSet<Integer> productos  = new TreeSet<>();
		productos = IntStream.range(1, 400).limit(200).mapToObj(t->Integer.valueOf(t)).collect(Collectors.toCollection(TreeSet::new));
		
		for (Integer producto : productos) {
			System.out.println(producto);
		}
		
		//Registor de pedidos de clientes
		NavigableMap<String, Queue<Integer>> pedidos = new TreeMap<>();
		pedidos.put("Andres", new LinkedList<Integer>());
		pedidos.put("Ramon", new LinkedList<Integer>());
		pedidos.put("Pedro", new LinkedList<Integer>());
		pedidos.put("Alberto", new LinkedList<Integer>());
		pedidos.put("Jaime", new LinkedList<Integer>());
		
		//Cada uno realiza un pedido de 10-20 productos de forma aletoria
		for(String cliente : pedidos.keySet()) {
			for(int i = 0; i < (new Random().nextInt(10)+10);i++) {
				//numero de productos
				int posPro = new Random().nextInt(productos.size());
				pedidos.get(cliente).add(productos.ceiling(posPro));
				productos.remove(productos.ceiling(posPro));
			}
		}
		
		
		//
		for (Map.Entry<String, Queue<Integer>> entry : pedidos.entrySet()) {
			String key = entry.getKey();
			Queue<Integer> val = entry.getValue();
			System.out.println(key+": "+val+" el primero es: "+val.peek() );
			
		}
		
	}

}
