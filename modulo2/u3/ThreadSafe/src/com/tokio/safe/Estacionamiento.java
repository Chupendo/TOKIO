package com.tokio.safe;

import java.util.ArrayList;
import java.util.List;

public class Estacionamiento implements Runnable {
	private static final int LIMIT = 50;
	List<Coche> lCoches=new ArrayList<>();
	
	public boolean estacionar(Coche coche) {
		if(lCoches.size()<LIMIT) {
			lCoches.add(coche);
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(coche.getMinutos()*1000);
						sacar(coche);
						System.out.println("Coche SALIENDO "+coche.getMatricula()+", quedan "+lCoches.size());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			}).start();
			return true;
		}
		return false;
	}
	
	public boolean sacar(Coche coche) {
		if(!lCoches.isEmpty()||lCoches.size()>0) {
			lCoches.remove(coche);
			return true;
		}
		return false;
	}
	
	public void run() {
		
	}
}
