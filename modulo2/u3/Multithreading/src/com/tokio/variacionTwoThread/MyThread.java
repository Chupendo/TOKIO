package com.tokio.variacionTwoThread;

import java.util.stream.IntStream;

public class MyThread implements Runnable {
	// Variable de insntica del subpreceso
	Thread th;

	// Crea un subproceso con esta Runnable
	// y le asigna el nombre
	public MyThread(String nameProcess) {
		this.th = new Thread(this, nameProcess);
	}

	//Méotdo que crea, inicia y devuelve un supbroceso
	public static MyThread createAndStart(String nameProcess) {
		MyThread mTh = new MyThread(nameProcess);
		//inicia la ejecución el subprocesos
		mTh.th.start();
		return mTh;
	}
	// Punto d entrada del subproceso
	@Override
	public void run() {
			IntStream.of(0,10).forEach(i->{
					try {
						Thread.sleep(400);//Sleep 0,4s
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("In "+th.getName()+", count is "+i);
			});
	}
}