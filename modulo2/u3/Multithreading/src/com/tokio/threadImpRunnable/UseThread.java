package com.tokio.threadImpRunnable;


public class UseThread {

	public static void main(String[] args) {
		System.out.println("Main thread starting");
		
		// Primero se crea objeto  MyThead de tipo Runnable
		MyThread mt = new MyThread("Child #1");
		
		// Segundo se crea un subprceso de MyThread
		Thread newThrd = new Thread(mt);
		
		// Se lanza el subproceso en paralelo al 
		// subproceso principal
		newThrd.start();
		
		for(int i=0;i<50;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Main thread ending");
	}
}
