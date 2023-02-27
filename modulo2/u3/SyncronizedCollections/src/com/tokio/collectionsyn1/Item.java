package com.tokio.collectionsyn1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Item {
	
	private int value;
	private ArrayList<Integer> list; //No sincronizada
	//private Vector<Integer> list; //Sincronizada
	private Random random;
	public Item() {
		list = new ArrayList<>();
		//list = new Vector<Integer>();
		random = new Random();
	}
	public int getValue() {
		return value;
	}
	
	private void setValue(int value) {
		this.value = value;
	}
	
	public void increment() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName()+" antes "+value);
			setValue(value+1);
			System.out.println(Thread.currentThread().getName()+" despues "+value);
		}
	}
	
	//public void createNumber() {
	public synchronized void createNumber() {
		list.add(random.nextInt(10000));
		System.out.println(list.toString());
	}
	
	//public synchronized void removeNumber() {
	public synchronized void removeNumber() {
		
		if(!list.isEmpty()||list.size()>0) {
			list.remove(0);
		}
	}
}
