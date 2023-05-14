package com.tokio.p6;

public class M2_P6_Andres_Ruiz_Penuela {

	public static void main(String[] args) {
		
		Bag<Integer> bag = new Bag<>();
		
		// comprobar el metodo de añadir elemento
		bag.add(1);
		bag.add(2);
		bag.add(3);
		
		// comprobar el metodo de clear
		bag.clear();
				
		// comprobar el metodo de extraer
		bag.add(1);
		bag.add(2);
		bag.add(3);
		System.out.println("extract: "+bag.extract());
		System.out.println("extract: "+bag.extract());
		System.out.println("extract: "+bag.extract());
		System.out.println("extract: "+bag.extract());
		
		// Comprobar el metodo de añadir
		bag.add(1);
		bag.add(2);
		bag.add(3);
		System.out.println("extract: "+bag.extract());
		System.out.println("extract: "+bag.extract());
		
		// Comprobar el metodo contains
		bag.show();
		System.out.println("contins 2? "+bag.contians(2));
		System.out.println("contins 3? "+bag.contians(3));
		System.out.println("contins 1? "+bag.contians(1));
	}
}
