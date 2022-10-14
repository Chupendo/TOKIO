/**
 * Práctica 13: Cuenta Bancaria
 * 
 * @author Andrés Ruiz Peñuela
 * @version 0.0.1
 */
public class M1_13_Andres_Ruiz_Penuela {

	public static void main(String[] args) {
		//testCuentaAhorros();  // Comprueba el uso de la clase CuentaAhorros
		//testCuentaBancaria(); // Comprueba el uso de la clase CuentaBancaria
	}
	
	public static void testCuentaAhorros() {
		//
		CuentaAhorros caa200 = new CuentaAhorros(200F, 2F);
		CuentaAhorros caa100 = new CuentaAhorros(100F, 2F);
		CuentaAhorros caa90 = new CuentaAhorros(90F, 2F);
		
		//
		System.out.println("caa 200: "+caa200.toString()+", esta activa: "+caa200.isActive());
		System.out.println("caa 100: "+caa100.toString()+", esta activa: "+caa100.isActive());
		System.out.println("caa  90: "+caa90.toString()+", esta activa: "+caa90.isActive());

		//
		System.out.println("Retiro de 20€:");
		caa200.retirarDinero(20F);
		caa100.retirarDinero(20F);
		caa90.retirarDinero(20F);
		mostrarCCAA(caa200,caa100,caa90);
		
		//
		System.out.println("Ingreso de 40€:");
		caa200.ingresarCantidad(20F);
		caa100.ingresarCantidad(20F);
		caa90.ingresarCantidad(20F);
		mostrarCCAA(caa200,caa100,caa90);
		
		//
		System.out.println("4 retrios de 20€ en caa200:");
		caa200.retirarDinero(20F);
		caa200.retirarDinero(20F);
		caa200.retirarDinero(20F);
		caa200.retirarDinero(20F);
		mostrarCCAA(caa200,caa100,caa90);
		
		
		//
		System.out.println(caa200.Imprimir());
		
		//
		System.out.println("extracto mensual de caa200: "+caa200.extractoMensual()+ " Eur.");
		System.out.println("extracto mensual de caa100: "+caa100.extractoMensual()+ " Eur.");
		System.out.println("extracto mensual de caa90: "+caa90.extractoMensual()+ " Eur.");
		
		//
		System.out.println("Nuevo mes");
		caa200.nuevoMes();	
		caa100.nuevoMes();
		caa90.nuevoMes();
		mostrarCCAA(caa200,caa100,caa90);
		System.out.println("extracto mensual de caa200: "+caa200.extractoMensual()+ " Eur.");
		System.out.println("extracto mensual de caa100: "+caa100.extractoMensual()+ " Eur.");
		System.out.println("extracto mensual de caa90: "+caa90.extractoMensual()+ " Eur.");
		
		//
		System.out.println("Seteo de saldo de todas las cuentas a 200 Eur.");
		caa200.saldo = 200F;
		caa100.saldo = 200F;
		caa90.saldo = 200F;
		mostrarCCAA(caa200,caa100,caa90);
	}

	public static void testCuentaBancaria() {
		CuentaBancaria cb200 = new CuentaBancaria(200, 2F);
		CuentaBancaria cb100 = new CuentaBancaria(100, 2F);
		CuentaBancaria cb90 = new CuentaBancaria(90, 2F);
		
		//
		System.out.println("cb 200: "+cb200.toString()+", sobregiro: "+cb200.sobregiro);
		System.out.println("cb 100: "+cb100.toString()+", sobregiro: "+cb100.sobregiro);
		System.out.println("cb  90: "+cb90.toString()+", sobregiro: "+cb90.sobregiro);
		
		System.out.println("Retiro de 100 Eur.:");
		cb200.retirarDinero(100F);
		cb100.retirarDinero(100F);
		cb90.retirarDinero(100F);
		mostrarCCB(cb200,cb100,cb90);
		
		//
		System.out.println(cb200.Imprimir());
		
		//
		System.out.println("extracto mensual de cb 200: "+cb200.extractoMensual()+ " Eur.");
		System.out.println("extracto mensual de cb 100: "+cb100.extractoMensual()+ " Eur.");
		System.out.println("extracto mensual de cb 90: "+cb90.extractoMensual()+ " Eur.");
		
		//
		System.out.println("Nuevo mes: ");
		cb200.nuevoMes();
		cb100.nuevoMes();
		cb90.nuevoMes();
		System.out.println(cb200.Imprimir());// Interes en saldo
		System.out.println(cb100.Imprimir());// Sin interes, cuenta vacia
		System.out.println(cb90.Imprimir()); // Tiene intereses en sobregiro
		mostrarCCB(cb200,cb100,cb90); // Muestra el resutlado del objeto, en un nuevo mes
	}
	public static void mostrarCCAA(CuentaAhorros...cuenta) {
		for (CuentaAhorros cuentaAhorros : cuenta) {
			System.out.println("caa: "+cuentaAhorros.toString()+", esta activa: "+cuentaAhorros.isActive());
		}
	}
	
	public static void mostrarCCB(CuentaBancaria...cuenta) {
		for (CuentaBancaria cuentaBancaria : cuenta) {
			System.out.println("caa: "+cuentaBancaria.toString()+", sobregiro: "+cuentaBancaria.sobregiro);
		}
	}
}
