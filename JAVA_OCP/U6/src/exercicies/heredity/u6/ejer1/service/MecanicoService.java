package exercicies.heredity.u6.ejer1.service;

import exercicies.heredity.u6.ejer1.dto.Coche;
import exercicies.heredity.u6.ejer1.dto.Mecanico;
import exercicies.heredity.u6.ejer1.dto.Moto;
import exercicies.heredity.u6.ejer1.dto.Vehiculo;

public class MecanicoService {

	public void pushRepair(Mecanico mecanico) {
		Vehiculo vh = getVehicule(mecanico);
		vh.setReparado(true);
	}
	public void deleteCarenado(Mecanico mecanico,Vehiculo vh1) {
		mecanico.getlVehiculo().stream()
			.filter(vh->vh.getId()==vh1.getId() && vh instanceof Moto && ((Moto) vh).isCarenado())
			.forEach(vh->{Moto mt =(Moto) vh; vh = MotoService.deleteCarenado((Moto)vh); });
		
		this.printLVehicule(mecanico);
	}

	public void pushNoRepair(Mecanico mecanico) {
		Vehiculo vh = getVehicule(mecanico);
		vh.setReparado(false);
	}

	public Vehiculo getVehicule(Mecanico mecanico) {
		int i = 1;
		short op = 0;
		for (Vehiculo vh : mecanico.getlVehiculo()) {
			System.out.println(i + " " + vh.getMatricula());			
		}
		do {
			op = VehiculoService.getShort("Indique el numero del vehiculo: ");
		} while (op <= 0 || op > mecanico.getlVehiculo().size());

		return mecanico.getlVehiculo().get(op-1);
	}

	public void addCoche(Mecanico mecanico) {
		System.out.println("Inserta datos de coche");
		Coche vh = CocheService.newCar();
		mecanico.getlVehiculo().add(vh);
	}

	public void addMoto(Mecanico mecanico) {
		System.out.println("Inserta datos de moto");
		Moto vh = MotoService.newMoto();
		mecanico.getlVehiculo().add(vh);
	}
	
	public static void printLVehicule(Mecanico mecanico) {
		mecanico.getlVehiculo().forEach(System.out::println);
	}
	
}
