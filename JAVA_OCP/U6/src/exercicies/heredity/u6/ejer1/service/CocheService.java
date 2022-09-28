package exercicies.heredity.u6.ejer1.service;

import java.util.Scanner;

import exercicies.heredity.u6.ejer1.dto.Coche;
import exercicies.heredity.u6.ejer1.dto.Vehiculo;

public class CocheService extends VehiculoService {

	public float addKm() {
		Scanner sc = new Scanner(System.in);
		float km;
		do {
			System.out.print("Inserte los kilmetros del vehiculo: ");
			
			try {
				km = sc.nextFloat();
				
			}catch(Exception ie) {
				System.err.println(ie);
				km = -1;
			}
			
			if(km!=-1) break;
		}while(true);
		
		return km;
	}
	

	public static Coche newCar() {
		
		Vehiculo vh = 	VehiculoService.newVehiculo();
		Coche ch= new Coche(vh);
		ch.setCapacidadMaletero(VehiculoService.getFloat("Inserte la capacidad del maletero: "));
		return ch;
	}

}
