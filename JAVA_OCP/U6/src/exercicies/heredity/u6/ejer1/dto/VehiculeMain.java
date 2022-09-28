package exercicies.heredity.u6.ejer1.dto;

import exercicies.heredity.u6.ejer1.service.CocheService;
import exercicies.heredity.u6.ejer1.service.MecanicoService;
import exercicies.heredity.u6.ejer1.service.MotoService;

public class VehiculeMain {

	public static void main(String[] args) {
		MecanicoService mcServie = new MecanicoService();
		
		Mecanico mc1 = new Mecanico("Andres", "Ruiz Peñuela", "arp@gmail.com", 'E', 50);
		mcServie.addCoche(mc1);
		mcServie.addMoto(mc1);
		

		mcServie.pushRepair(mc1);
		Vehiculo vh = mcServie.getVehicule(mc1);
		
		if(vh instanceof Moto) {
			System.out.println("es una referencia a Moto");
			mcServie.deleteCarenado(mc1, vh);
		}
		
		//Quitar Carenado sin comprobacion de si es vehiculo o no
		mcServie.deleteCarenado(mc1, vh);
	}

}
