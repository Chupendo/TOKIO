package com.tokio.ejercicio12;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		final Queue q1 = new Queue(10);

		Runnable producer = () -> {
			Random rd = new Random();
			synchronized (q1) {
				while (true) {
					if (q1.index > q1.getTope()-1) {
						try {
							q1.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					q1.add(rd.nextInt());
					q1.notify();
				}
			}
		};

		Runnable consumer = () -> {
			synchronized (q1) {
				while (true) {
					if (q1.index <=0) {
						try {
							q1.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					if (q1.index == 0)
						System.out.println(q1.get());
					else
						System.out.print(q1.get()+" ");
					q1.notify();
				}
			}
		};
		
		Thread th1 = new Thread(producer,"Producer #1");
		Thread th2 = new Thread(consumer,"Consumer #1");
		
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
