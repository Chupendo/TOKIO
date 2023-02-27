package com.tokio.collectionsyn2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class Item {
	
	private AtomicInteger value;
	private List<Integer> list; //No sincronizada

	private Random random;
	public Item() {
		//Lista sincronizada
		list = Collections.synchronizedList(getData());

		random = new Random();
	}
	public ArrayList<Integer> getData(){
		return new ArrayList<>();
	}
	public int getValue() {
		//metodo atomico
		return value.get(); 
	}
	
	private void setValue(int value) {
		//meotod atomico
		this.value.set(value);
	}
	
	public void increment() {
		System.out.println(Thread.currentThread().getName()+" antes "+value);
		System.out.println(Thread.currentThread().getName()+" despues "+this.value.incrementAndGet());
	}
	
	//public void createNumber() {
	public void createNumber() {
		list.add(random.nextInt(10000));
		System.out.println(list.toString());
	}
	
	//public synchronized void removeNumber() {
	public void removeNumber() {
		
		if(!list.isEmpty()||list.size()>0) {
			list.remove(0);
		}
	}
}
