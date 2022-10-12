
public class M1_13_Andres_Ruiz_Penuela {

	public static void main(String[] args) {
		testCuentaAhorros();
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

	public static void mostrarCCAA(CuentaAhorros...cuenta) {
		for (CuentaAhorros cuentaAhorros : cuenta) {
			System.out.println("caa: "+cuentaAhorros.toString()+", esta activa: "+cuentaAhorros.isActive());
		}
	}
}
