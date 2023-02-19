package com.tokio.synchronizedOne;

public class OperationThread implements Runnable {
	Thread thrd;
	int a[];
	int answer;
	//Al ser estatico, es un recurso compartido 
	//para todos los subpreceso, si no lo fuera
	//no haria falta ser sincronizado
	static Operation operation;
	
	//Crea un nuevo subproceso
	public OperationThread(String name, int nums[]) {
		thrd = new Thread(this,name);
		a = nums;
		operation = new Operation();
	}
	
	//Metodo que fabrica e inicia el subprocesoç
	public static OperationThread creaOperationThread(String name,int nums[]) {
		OperationThread operationThread = new OperationThread(name, nums);
		operationThread.thrd.start();//inicia subproceso
		return operationThread;
	}
	
	@Override
	public void run() {
		
		System.out.println(thrd.getName()+" starting");
		answer = operation.sumArray(a);
		System.out.println("Sum for "+thrd.getName()+ " is "+answer);
		System.out.println(thrd.getName()+" ending");

	}

}
