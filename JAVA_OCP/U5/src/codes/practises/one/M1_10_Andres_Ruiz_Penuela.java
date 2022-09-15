package codes.practises.one;

import java.util.Calendar;

public class M1_10_Andres_Ruiz_Penuela {

	public static void main(String[] args) {
		// Persona 1
		Calendar cal = Calendar.getInstance();
		cal.set(1992, 05, 06);
		Persona p1 = new Persona("Andrés", "Ruiz Peñuela", "25488975B", cal.getTime());

		// Persona 2 (no cumple el forma del dni)
		cal.set(1992, 05, 06);
		Persona p2 = new Persona("Ramón", "Sánches Pérez", "98766513", cal.getTime());
		
		System.out.println("Persona 1:"+p1);
		System.out.println("Persona 2:"+p2);
	}

}
