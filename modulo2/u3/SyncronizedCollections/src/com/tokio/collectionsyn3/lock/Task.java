package com.tokio.collectionsyn3.lock;

import java.util.concurrent.locks.Lock;

public class Task implements Runnable {
	private Item item;
	private Lock lock;

	public Task(Item item,Lock lock) {
		this.item = item;
		this.lock = lock;
	}

	@Override
	public void run() {
		while (true) {
			// item.increment();
			lock.lock();

			item.createNumber();
			item.removeNumber();

			lock.unlock();

			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}

	}
}
