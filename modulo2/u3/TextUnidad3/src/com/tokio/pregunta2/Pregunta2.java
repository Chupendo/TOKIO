package com.tokio.pregunta2;

public class Pregunta2 extends Thread {
	public static void main(String[] args) {
		Pregunta2 t = new Pregunta2(); /*Linea 5 */
		t.run(); /*Linea 6*/
	}

	@Override
	public void run() {
		for(int i =1;i<3;i++){
			System.out.print(i+ "..");
		}

	}
}
