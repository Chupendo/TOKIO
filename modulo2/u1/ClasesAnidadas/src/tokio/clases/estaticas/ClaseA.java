package tokio.clases.estaticas;

class ClaseA {

	// Miembro estatico
	static int externo_x = 10;
	// Miembro de instancia
	int externo_y = 20;
	// Miembro privado
	private static int externo_privado = 30;

	public void msgA() {
		System.out.println("Hola soy la clase externa.");
	}

	public static class ClaseB {

		public void msgB() {
			System.out.println("Hola soy la clase interna.");
		}

		void mostrar() {
			// Puede acceder al miembro estatico de la clase externa
			System.out.println("externo_x: " + externo_x);
			/* Puede acceder a mostrar un miembro estatico privado de la clase externa */
			System.out.println("externo_privado: " + externo_privado);
			/*
			 * La siguiente declaracion generara un error de compilacion, ya que la clase
			 * anidada estatica no puede acceder directamente a un miembro no estatico
			 */
			//System.out.println("externo_y =" + externo_y);
		}

	}
}
