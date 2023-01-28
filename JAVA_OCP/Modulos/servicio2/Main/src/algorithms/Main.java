package algorithms;

import algorithms.sor.UtilOrdenar;

public class Main {

	public static void main(String[] args) {
		UtilOrdenar nom = new UtilOrdenar();
		
		//El array de srot() debe implmentar la interfaz Comparable
		String[] lnom = {"Ramon","Pedro","Andres"};
		nom.sort(lnom);
		
		//La clase coche debe implmentar la interaz Compparable, de lo contrario da error al compilar 
		Coche[] lcoche = {new Coche("BMW"),new Coche("Audi"),new Coche("Kia"),new Coche("Suziki")};
		nom.sort(lcoche);
	}
}
