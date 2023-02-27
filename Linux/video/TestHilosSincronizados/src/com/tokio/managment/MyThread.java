package com.tokio.managment;

/*
 * Ejemplo de un hilo que controla
 * la gestión de ejecuión: 
 *  stop(),supended(),resumed()
 */
public class MyThread implements Runnable {
	Thread th;
	private boolean suspended;
	private boolean stopped;

	public MyThread(String name) {
		th = new Thread(this, name);
		// Si es true suspende el proceso
		suspended = false;
		// Si es true para el proceso
		stopped = false;
	}

	public static MyThread createAndStart(String name) {
		MyThread sub = new MyThread(name);
		sub.th.start();
		return sub;
	}

	@Override
	public void run() {

		try {
			for (int i = 0; i < 1000; i++) {
				System.out.print(i + " ");
				// Cuando cuenta 10 salta la linea
				// y espera
				if (i != 0 && (i % 10) == 0) {
					System.out.println();
					Thread.sleep(250);
				}
				
				//Se sincroniza solo suspend  o stoppedManagmentMain.java
				//de la instanica
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
