package com.tokio.examplebasic;

import java.util.stream.IntStream;

/**
 * En este ejemplo, se crea un objeto Thread que una instancia que hereda de “Thread” 
 * en lugar de una instancia que implementa la intefar “Runnable”.
 * @author andre
 *
 */
public class MyThread extends Thread{
	
	@Override
	public void run() {
		IntStream.range(0, 100).forEach(System.out::print);
		System.out.println();
	}
	
	public static void main(String[] args) {
		Thread th = new Thread(new MyThread());
		System.out.println("start process main");
		//th.run();
		th.start();
		System.out.println("end process main");
	}
}
