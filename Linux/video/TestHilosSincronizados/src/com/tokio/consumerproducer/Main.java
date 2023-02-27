package com.tokio.consumerproducer;


public class Main {

	public static void main(String[] args) {
		System.out.println("Consumer & Producer start ");
		final ConsumerProducer cp = new ConsumerProducer();
		Runnable consumer = ()->{
			try {
				cp.consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Runnable producer = ()->{
			try {
				cp.producer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Thread csTH = new Thread(consumer, "Consumer #1");
		Thread prTH = new Thread(producer, "Producer #1");
		
		csTH.start();
		prTH.start();
		
		try {
			csTH.join();
			prTH.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
