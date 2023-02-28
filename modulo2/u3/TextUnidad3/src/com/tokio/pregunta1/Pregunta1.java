package com.tokio.pregunta1;

public class Pregunta1 implements Runnable {
	public static void main(String[] args) {
		Pregunta1 t = new Pregunta1();
		Thread x = new Thread(t);
		
		x.start();
	}

	@Override
	public void run() {
		for(int i =0;i<3;i++){
			System.out.print(i+ "..");
		}

	}
}
