package com.tokio.collectionsyn1;

public class Task implements Runnable {
	private Item item;
	
	public Task(Item item) {
		this.item = item;
	}
	@Override
	public void run() {
		while(true) {
			//item.increment();
			item.createNumber();
			item.removeNumber();
			try {
				Thread.sleep(500);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}

	}
}
