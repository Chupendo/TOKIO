package exercicies.heredity.u6.ejer1.service;

import exercicies.heredity.u6.ejer1.dto.Moto;
import exercicies.heredity.u6.ejer1.dto.Vehiculo;

public class MotoService extends VehiculoService {

	public static Moto deleteCarenado(Moto moto) {
		if (!moto.isCarenado())
			return null;

		moto.setCarenado(false);
		moto.setPeso(moto.getPeso() - 2);
		return moto;
	}

	public static Moto newMoto() {

		Vehiculo vh = VehiculoService.newVehiculo();
		Moto ch = new Moto(vh);
		ch.setCarenado(VehiculoService.getBoolean("Moto con carenado? (1-true o 0-false):"));
		ch.setPeso(VehiculoService.getFloat("Inserte el peso de la moto: "));
		return ch;
	}
}
