package examples.heredity.u6.m1.example2;

import examples.heredity.u6.m1.example2.Example2.Coche;
import examples.heredity.u6.m1.example2.Example2.Vehiculo;
import examples.heredity.u6.m1.example2.subpackage.Moto;


public class VehiculoTest {

	public static void main(String[] args) {
		
		// Vehiculo y Moto es una clase públicas
		// por lo que es accesible por
		// cualquier clase
		Vehiculo v1 = new Vehiculo(0, null, null);
		Moto m1 = new Moto(0, null, null, 0);
		
		
		// Coche es una clase protected
		// por lo que es visibles por otra clase
		// del mismo paquete
		Coche ch1 = new Coche(0, null, null, 0);
		
		// Camion es una clase privada, por lo que no es
		// acesible directmaente por clases
		// ajena a su clase externa
		// Las clases privadas solo existen dentro de
		// otras clases (son inner-class)
		// Camion cm1 = new Camion(0, null, null, 0,0);
	}
}
