package codes.exercicies.tokio.activies.four;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancariaDemo {

	public static void main(String[] args) {
		List<CuentaBancaria> lCC = new ArrayList<CuentaBancaria>();

		// cantidad de la cuenta negativa
		try {
			lCC.add(new CuentaBancaria(-2, "3333333ES", 1.2F, "Andres", "Sabadel"));
		} catch (RuntimeException e) {
			System.err.println(e);
		}

		// lista de cuentas
		try {
			lCC.add(new CuentaBancaria(0, "3333333ES", 1.2F, "Andres", "Sabadel"));
			lCC.add(new CuentaBancaria(1234.43, "444898ES", 0.6F, "Ramon", "Caixa"));
			lCC.add(new CuentaBancaria(1234.55, "333666995ES", 2F, "Marco", "Sabadel"));
		} catch (RuntimeException e) {
			System.err.println(e);
		}

		// mostramos la lista de cuentas
		lCC.forEach(System.out::println);
		System.out.println();
		
		// cantidad de ignreso por debajo de la cnatidad en la cuenta
		try {
			lCC.get(1).ingresing(12);
		} catch (RuntimeException e) {
			System.err.println(e);
		}

		// mostramos la lista de cuentas tras un ingreso erroeno
		System.out.println("Resutlado de un ingreso en la cuenta"+lCC.get(1).getNumberCount()+" erroneo");
		lCC.forEach(System.out::println);
		System.out.println();
		
		// cantidad de ignreso por encima de la cnatidad en la cuenta
		try {
			lCC.get(0).ingresing(1500);
		} catch (RuntimeException e) {
			System.err.println(e);
		}

		// mostramos la lista de cuentas
		System.out.println("Resutlado de un ingreso en la cuenta"+lCC.get(1).getNumberCount()+" favorable");
		lCC.forEach(System.out::println);
		System.out.println();
	}
}
