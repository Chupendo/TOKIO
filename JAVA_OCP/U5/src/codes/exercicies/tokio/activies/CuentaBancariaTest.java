package codes.exercicies.tokio.activies;

public class CuentaBancariaTest {

	public static void main(String[] args) {
		CuentaBancaria c1 = new CuentaBancaria(1234532,"Andres",132.0,6);
		
		System.out.println(c1.toString());
		System.out.println(c1.calcularInteresMensual(5));
		
	}
}
