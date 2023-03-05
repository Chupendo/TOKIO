package com.tokio.semaforo;

public class SemaforoService {
	private boolean changed;
	
	public SemaforoService() {
		this.changed = false;
	}
	
	public void waitToChanged() throws InterruptedException {
		while(!changed) {
			wait();
		}
		changed = false;
	}
	
	public SemaforoEnum runLigth(SemaforoEnum semaforo) throws InterruptedException {
		switch (semaforo) {
		case VERDE:
			Thread.sleep(1000);
			break;
		case ROJO:
			Thread.sleep(1000);
			break;
		case AMARILLO:
			Thread.sleep(1000);
			break;	
		}
		changed = true;
		notify();
		return changedColor(semaforo);
	}
	
	public SemaforoEnum changedColor(SemaforoEnum semaforo) {
		SemaforoEnum resul = null;
		switch (semaforo) {
		case VERDE:
			resul = SemaforoEnum.AMARILLO;
			break;
		case ROJO:
			resul = SemaforoEnum.VERDE;
			break;
		case AMARILLO:
			resul = SemaforoEnum.ROJO;
			break;	
		}
		
		return resul;
	}
}
