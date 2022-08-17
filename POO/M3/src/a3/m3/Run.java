package a3.m3;

public class Run {

	public static void main(String[] args) {
		/** Ejemplo de uso de poliformimos paramétrico **/
		// Conversión implicita: Refecnia del objeto Person = refencia del Objeto
		// Client/Employee (clases hijas)
		Person p1 = new Client("Andres", "Perez Math", 30, 1);
		Person p2 = new Employee("Ramon", "Lopez San", 25, "1AB");

		// Instancia de Cliente y Empleado
		Client c1 = new Client("Marcos", "Bentura Bezrosa", 3);
		Employee e1 = new Employee("Pedro", "Sanchez Paz", 25, "1A");

		/** Ejemplo de uso de poliformismo de sobrecarga **/
		System.out.println("------------------");
		System.out.println("Objetos:");
		System.out.println("------------------");
		System.out.println(p1.toString() + "\n" + c1.toString() + "\n" + p2.toString() + "\n" + e1.toString());

		/** Ejemplo de uso de poliformimos inclusión **/
		// "msgWelcome" es una operacion implentada en las clases hijas de Person

		try {
			System.out.println("------------------");
			System.out.println("Codigo de Cliente/Empleado:");
			System.out.println("------------------");
			System.out.println(((Client) p1).msgWelcome());
			System.out.println(((Employee) p2).msgWelcome());
			System.out.println(c1.msgWelcome());
			System.out.println(e1.msgWelcome());
		} catch (ClassCastException ex) {
			System.err.println("Error al realiza la converisón de tipos " + ex);
		}
	}

}
