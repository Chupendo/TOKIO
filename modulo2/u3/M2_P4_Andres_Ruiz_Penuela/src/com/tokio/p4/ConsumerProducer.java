package com.tokio.p4;

import java.util.List;
import java.util.Random;

public class ConsumerProducer implements Runnable {
	Thread th;
	private static final int MAX = 10;
	public List<Integer> lNums;
	//Operaciones obre la lista
	static Operations op = new Operations();

	public ConsumerProducer(String name,List lNums) {
		this.th = new Thread(this, name);
		this.lNums = lNums;
	}

	//Crea, iniciaa y delvueve un subprocesos
	public static ConsumerProducer createAndStart(String name,List lNums) {
		ConsumerProducer cp = new ConsumerProducer(name,lNums);
		cp.th.start();
		return cp;
	}
	

	//Punto de inicio del subproceso
	@Override
	public void run() {
		//Cuenta el numero de operaciones
		int count = 0;
		
		//Semilla para generar elementos
		Random rd = new Random();
		
		while (count<2*MAX) {
			//Sincroniza las operciones
			//si comprate algún elemento en común entre 
			//subprocesos, JAVa sincroniza
			synchronized (op) {
				if (th.getName().contains("producer")) {
					//Productor
					if (lNums.size() == MAX) {
						try {
							op.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					op.add(lNums, rd.nextInt());
					op.notify();
				}else {
					//Consumidor
					if (lNums.isEmpty()||lNums.size()==0) {
						try {
							op.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.print(op.get(lNums)+" ");
					op.notify();
					
				}
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			count++;
		}
	}
}
