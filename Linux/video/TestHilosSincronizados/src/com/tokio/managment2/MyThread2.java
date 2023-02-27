package com.tokio.managment2;

/*
 * Ejemplo de un hilo que controla
 * la gestión de ejecuión: 
 *  stop(),supended(),resumed()
 */
public class MyThread2 implements Runnable {
	Thread th;
	private boolean suspended;
	private boolean stopped;
	int[] v;
	public MyThread2(String name, int[] v) {
		th = new Thread(this, name);
		// Si es true suspende el proceso
		suspended = false;
		// Si es true para el proceso
		stopped = false;
		
		this.v=v;
	}

	public static MyThread2 createAndStart(String name,int[] v) {
		MyThread2 sub = new MyThread2(name,v);
		sub.th.start();
		return sub;
	}

	@Override
	public void run() {
		synchronized (v) {

			try {
				for (int i = 0; i < v.length; i++) {
					System.out.print(i + " ");
					// Cuando cuenta 10 salta la linea
					// y espera
					if (i != 0 && (i % 10) == 0) {
						System.out.println();
						Thread.sleep(250);
					}

					// Se sincroniza solo suspend o stoppedManagmentMain.java
					// de la instanica
					synchronized (this) {
						// Comprueba si pausa el proceso
						while (suspended) {
							wait();
						}

						// Comprueba si para el proceso
						if (stopped)
							break;

					}
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	synchronized public void mySuspend() {
		suspended = true;
	}

	synchronized public void myStopped() {
		stopped = true;

		// Garantiza que no este suspendido
		suspended = false;
		notify();
	}

	synchronized public void myResumed() {
		suspended = false;
		notify();
	}
}
