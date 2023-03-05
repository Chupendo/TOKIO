package com.tokio.semaforo;

public class SemaforoThread implements Runnable {
	SemaforoEnum semaforo;
	Thread th;
	SemaforoService service;

	public SemaforoThread(SemaforoEnum semaforo) {
		this.th = new Thread(this);
		this.semaforo = semaforo;
		this.service = new SemaforoService();
	}

	@Override
	public void run() {
		synchronized (service) {

			for (int i = 0; i < 9; i++) {
				try {
					System.out.println(this.semaforo);
					semaforo = this.service.runLigth(semaforo);
					this.service.waitToChanged();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
