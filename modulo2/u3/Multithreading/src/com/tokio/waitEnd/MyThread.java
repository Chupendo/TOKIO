package com.tokio.waitEnd;

import java.util.stream.IntStream;


public class MyThread implements Runnable {
	//Subpocesos
	public Thread th;
	
	//Crea un subproseo
	public MyThread(String nameSubProccess) {
		th = new Thread(this, nameSubProccess);
	}
	
	//Crea, inicia y devueve un subproceso
	public static MyThread createAndStart(String name) {
		MyThread mTh = new MyThread(name);
		mTh.th.start();
		return mTh;
	}
	
	// Punto de entrada del subproceso
	@Override
	public void run() {
		System.out.println(th.getName()+" starting!");
		
		try {
			Thread.sleep(400);
			IntStream.range(0, 10)
			.forEach(i->System.out.println("In "+th.getName()+", count is "+i));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(th.getName()+" ending!");
	}
}
