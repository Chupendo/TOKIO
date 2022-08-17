package a3.m2;

import java.util.InputMismatchException;

public interface IOperacionesCuenta {

	public Cuenta nuevaCuenta();
	public void verCuentas(Cuenta[] cuentas);
	public Cuenta obetenerCuentaConMasDinero(Cuenta c1,Cuenta c2);
	
}
