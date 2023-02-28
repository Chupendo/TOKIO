package com.tokio.collectionsyn3.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CollectionSynMain {

	public static void main(String[] args) {
		Item item = new Item();
		Lock lock = new ReentrantLock();
		ExecutorService executor = Executors.newCachedThreadPool();
		
		executor.execute(new Task(item,lock));
		executor.execute(new Task(item,lock));
		executor.execute(new Task(item,lock));
		executor.execute(new Task(item,lock));
		executor.execute(new Task(item,lock));
		executor.execute(new Task(item,lock));
		
		executor.shutdown();

	}
}
