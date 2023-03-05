package com.tokio.semaforo;

public class Main {

	public static void main(String[] args) {
		SemaforoEnum semaforo = SemaforoEnum.VERDE; 
		SemaforoThread semaforo1 = new SemaforoThread(semaforo);
		SemaforoThread semaforo2 = new SemaforoThread(semaforo);
		semaforo1.th.start();
		semaforo2.th.start();
		try {
			semaforo1.th.join();
			semaforo2.th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
