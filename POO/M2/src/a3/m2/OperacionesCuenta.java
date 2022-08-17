package a3.m2;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Clase Cuenta
 * @author andre
 *
 */
public class OperacionesCuenta implements IOperacionesCuenta {

	/**
	 * Metodo que solicita los datos de una cuenta y la devuelve
	 * @return cuenta:Cuenta
	 */
	@Override
	public Cuenta nuevaCuenta() {
		Cuenta cuenta = new Cuenta();
		Scanner sc = new Scanner(System.in);
		char ok = 'n';
		
		//Captura del titula de cuenta
		System.out.print("Agrege el titular de la cuenta: ");
		cuenta.setTitular(sc.nextLine());
		
		//Captura del numero de cuenta
		do {
			try {
			System.out.print("Agrege numero de cuenta: ");
			cuenta.setNumeroCuenta(sc.nextLong());
			ok = 'y';
			}catch(NoSuchElementException | IllegalStateException ex) {
				System.err.println("El numero no es valido - "+ex);
				ok = 'n';
				sc.nextLine();//Limia el terminal, me genera un bulce infinio si se produce una excecion
			}
		}while(ok!='y');
		
		//Captura de la cantidad de cuenta
		do {
			try {
			System.out.print("Agrege cantidad de cuenta: ");
			cuenta.setCantidad(sc.nextDouble());
			ok = 'y';
			}catch(NoSuchElementException | IllegalStateException ex) {
				System.err.println("El numero no es valido - "+ex);
				ok = 'n';
				sc.nextLine();//Limia el terminal, me genera un bulce infinio si se produce una excecion
			}
		}while(ok!='y');
		
		//Devuelve el resultado.
		return cuenta;
	}
	
	/**
	 * Metodo que muestra un array de cuentas por consola
	 * @return void
	 */
	@Override
	public void verCuentas(Cuenta[] cuentas) {
		for (Cuenta cuenta : cuentas) {
			System.out.println(cuenta);
		}
	}
	
	/**
	 * Metodo que compara dos cuentas y devuelve cual es mayor, si son iguales, devuelve null
	 * return cuenta:Cuenta
	 */
	@Override
	public Cuenta obetenerCuentaConMasDinero(Cuenta c1, Cuenta c2) {
		if( c1.getCantidad().equals(c2.getCantidad()) ) {
			return null;
		}else {
			if(c1.getCantidad()>c2.getCantidad()) {
				return c1;
			}else {
				return c2;
			}
		}
	}
	
	
}
