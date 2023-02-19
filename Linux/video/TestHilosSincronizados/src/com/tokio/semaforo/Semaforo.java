package com.tokio.semaforo;

public class Semaforo {
	
	public enum ESTADO {ROJO, VERDE, AMARILLO}
	private ESTADO stated = ESTADO.ROJO;
	private boolean init = false;
	synchronized public void rojo(boolean running) throws InterruptedException {
		if(stated.equals(ESTADO.ROJO)) {
			init = true;
		}
		while(true) {
			
			if(stated.compareTo(ESTADO.ROJO)!=0 || !init) {
				wait();
			}
			
			System.out.println(stated+" ");
			//cambio de estado
			stated = ESTADO.VERDE;
			
			notify();
			Thread.sleep(100);
		}
	}
	
	synchronized public void amarillo(boolean running) throws InterruptedException {
		if(stated.equals(ESTADO.AMARILLO)) {
			init = true;
		}
		while(true) {
			
			if(stated.compareTo(ESTADO.AMARILLO)!=0 || !init) {
				wait();
			}
			
			System.out.print(stated+"  ");
			//cambio de estado
			stated = ESTADO.ROJO;
			
			notify();
			Thread.sleep(100);
		}
	}
	
	synchronized public void verde(boolean running) throws InterruptedException {
		if(stated.equals(ESTADO.VERDE)) {
			init = true;
		}
		while(true) {
			
			if(stated.compareTo(ESTADO.VERDE)!=0 || !init) {
				wait();
			}
			
			System.out.print(stated+" ");
			//cambio de estado
			stated = ESTADO.AMARILLO;
			
			notify();
			Thread.sleep(100);
		}
	}
}
