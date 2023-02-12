package com.tokio.mejoraThread;

import java.util.stream.IntStream;

public class MyThread implements Runnable {
	//Subprocess
	Thread th;
	
	public MyThread(String name) {
		//New subprocess with name 
		th = new Thread(this, name);
	}
	
	//Make
	@Override
	public void run() {			
		System.out.println(th.getName()+" starting");
		IntStream.range(0,20).forEach(x->System.out.println(th.getName()+"... step "+x));
		System.out.println(th.getName()+" ending");
	}

}
