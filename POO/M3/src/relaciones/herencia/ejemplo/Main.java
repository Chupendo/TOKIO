package relaciones.herencia.ejemplo;

public class Main {

	public static void main(String[] args) {
		 CentroComercial centroComercial = new CentroComercial();

	        Cliente cliente1 = new Cliente("Jorge", 100);
	        Cliente cliente2 = new Cliente("Maria", 200);

	        /*Se añade tienda a centro comercial y se establece una relación de COMPOSICIÓN */

	        centroComercial.nuevaTienda();

	        /*Se añade un cliente a centro comercial y se establece una relación de AGREGACIÓN */

	        centroComercial.agregarCliente(cliente1);
	        centroComercial.agregarCliente(cliente2);

	        centroComercial.verClientes().forEach(System.out::println);
	        centroComercial.verTienda().forEach(System.out::println);
	        
	        /* Se destruye centro comercial y por lo tanto los objetos de tipo Tienda que contiene. Los objetos tipo Cliente se mantienen, pero se elimina su relación */
	        centroComercial = null;
	        
	        centroComercial.verClientes().forEach(System.out::println);
	        centroComercial.verTienda().forEach(System.out::println);//Error
	}
}
