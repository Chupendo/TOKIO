package com.tokio.p4;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//Consumidor y Productor comparte la lista de numeros
		List<Integer> lNums = new ArrayList<>();
		//Subprocesos
		ConsumerProducer consumer = ConsumerProducer.createAndStart("consumer",lNums);
		ConsumerProducer producer = ConsumerProducer.createAndStart("producer",lNums);
		
		
		try {
			consumer.th.join();
			producer.th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
