package com.tokio.priority;

public class PriorityDemo {

	public static void main(String[] args) {
		
		//crear subprocesos
		Priority mt1 = new Priority("High Priority");
		Priority mt2 = new Priority("Low Priority");
		Priority mt3 = new Priority("Normal Priority #1");
		Priority mt4 = new Priority("Normal Priority #2");
		Priority mt5 = new Priority("Normal Priority #3");
		
		//establecer prioridades
		mt1.th.setPriority(Thread.MAX_PRIORITY);
		mt2.th.setPriority(Thread.NORM_PRIORITY-2);
		
		//iniciar subprocesos
		mt1.th.start();
		mt2.th.start();
		mt3.th.start();
		mt4.th.start();
		mt5.th.start();
		
		try {
			mt1.th.join();
			mt2.th.join();
			mt3.th.join();
			mt4.th.join();
			mt5.th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nResult");
		System.out.println(mt1.th.getName()+" thread counted to "+mt1.count);
		System.out.println(mt2.th.getName()+" thread counted to "+mt2.count);
		System.out.println(mt3.th.getName()+" thread counted to "+mt3.count);
		System.out.println(mt4.th.getName()+" thread counted to "+mt4.count);
		System.out.println(mt5.th.getName()+" thread counted to "+mt5.count);
	}
}
