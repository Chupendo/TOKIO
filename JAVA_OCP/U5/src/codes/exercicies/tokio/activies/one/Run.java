package codes.exercicies.tokio.one;

import java.util.Date;

public class Run {

	public static void main(String[] args) {
		Electrodomestico e1, e2; //Declaración: guarda memoria
		e1 = new Electrodomestico(new Date(), 3.5F, "LG"); // Instanciación: Se obtiene la referencia del objeto
		e2 = new Electrodomestico(new Date(), 5.5F, "LG");
		
		System.out.println(e1);
		System.out.println(e2);
	}
}
