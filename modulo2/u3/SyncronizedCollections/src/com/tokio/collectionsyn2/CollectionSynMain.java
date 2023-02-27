package com.tokio.collectionsyn2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CollectionSynMain {

	public static void main(String[] args) {
		Item item = new Item();
		ExecutorService executor = Executors.newCachedThreadPool();
		
		executor.execute(new Task(item));
		executor.execute(new Task(item));
		executor.execute(new Task(item));
		executor.execute(new Task(item));
		executor.execute(new Task(item));
		executor.execute(new Task(item));
		
		executor.shutdown();

	}

}
