package com.tokio.priority;

public class Priority implements Runnable {
	//numero de veces que entra en la
	//CPU el subpreceso
	int count;
	// Subpocesos
	public Thread th;

	//Variables de clase
	static boolean stop = false;
	//Determina que Subprecso esta en ejeución
	static String currentName;

	// Crea un subproseo
	public Priority(String nameSubProccess) {
		th = new Thread(this, nameSubProccess);
		count = 0;
		currentName = nameSubProccess;
	}

	// Punto de entrada del subproceso
	@Override
	public void run() {
		System.out.println(th.getName() + " starting!");
		do {
			count++;
			// Comprara currentName con el nombre del supbroceso
			// en ejecución
			if (currentName.compareTo(th.getName()) != 0) {
				// Si no coincde, se han intercambiado las tareas
				// es decir, puede ver que subprcoeso esta en la
				// CPU de forma imprecisa en cada comento
				currentName = th.getName(); // Subprcoes que esta en el CPU
				System.out.println("In " + currentName);
			}
		} while (!stop && count < 100000);

		//Detiene el resto de subprecesos
		//el primer subprceso que cuente hasta 100000
		stop = true;

		System.out.println(th.getName() + " ending!");
	}
}
