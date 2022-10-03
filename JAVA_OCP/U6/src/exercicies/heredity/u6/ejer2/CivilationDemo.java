package exercicies.heredity.u6.ejer2;

import exercicies.heredity.u6.ejer2.service.CivilitationService;

public class CivilationDemo {
	public static final CivilitationService service = new CivilitationService();
	
	public static void main(String[] args) {
		JugadroDto jg1 = new JugadroDto("Andres", "Ruiz Peñuela", "Chupendo", System.currentTimeMillis(), 
				new PersonajeDto("Tidus", "Oro", null));

		System.out.println("INIT");
		System.out.println(jg1.toString());
		
		CivilitationService.createCity(jg1);
		System.out.println("CREATE CITY");
		System.out.println(jg1.toString());

		short i = 0;
		do {
			System.out.println("CREATE +LEVEL");
			System.out.println(jg1.toString());
			CivilitationService.uppNevel(jg1);
			i++;
			try {
				synchronized(service) {
					service.esperar();
			      }
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(i<22);
	}
}
