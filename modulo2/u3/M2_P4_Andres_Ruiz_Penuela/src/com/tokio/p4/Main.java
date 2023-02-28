package com.tokio.p4;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		//Consumidor y Productor comparte la lista de numeros
		List<Integer> lNums = new ArrayList<>();
		//Subprocesos
		//Requisito: El nombre de los procesos para evitar error debe contener consumer o producer
		ConsumerProducer consumer = ConsumerProducer.createAndStart("consumer 1",lNums);
		ConsumerProducer producer = ConsumerProducer.createAndStart("producer 1",lNums);
		
		
		try {
			consumer.th.join();
			producer.th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
