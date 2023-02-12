package com.tokio.multripocess;

import java.util.stream.IntStream;

public class MoreTrhreads {

	public static void main(String[] args) {
		System.out.println("Main thread startign.");
		//Crea e inicia 3 subprocesos
		MyThread mt1 = MyThread.createAndStart("Child 1#");
		MyThread mt2 = MyThread.createAndStart("Child 2#");
		MyThread mt3 = MyThread.createAndStart("Child 3#");
		
		IntStream.of(0,50).forEach(i->
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.err.println("Main trhead interrrumped.");
			}
		});
		System.out.println("Main thread ending.");
	}
}
