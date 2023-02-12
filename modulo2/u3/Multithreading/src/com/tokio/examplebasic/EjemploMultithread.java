package com.tokio.examplebasic;

import java.util.stream.IntStream;

public class EjemploMultithread implements Runnable {
	
	public static void main(String[] args) {
		
		//Crea un objeto ejectuable
		EjemploMultithread objRun = new EjemploMultithread();
		
		System.out.println("start");
		//Hilo 1
		Thread ejempeloThread1 = new Thread(objRun,"thread1");
		//Ejecuta el codigo del metdo "run()" de Thread
		//en segudno plano y continua el flujo del programa
		ejempeloThread1.start();
		
		//Hilo 2
		Thread ejempeloThread2 = new Thread(objRun,"thread1");
		//Ejecuta el codigo del metdo "run()" de Thread
		//en segudno plano y continua el flujo del programa
		ejempeloThread2.start();
		
		System.out.println("end");
	}
	
	@Override
	public void run() {
		IntStream.range(0, 20).forEach(System.out::println);
	}
}
