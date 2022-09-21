package examples.heredity.u6.m1.example3;

public class Example3 {

	public static void main(String[] args) {
		Trabajador work = new Trabajador();
		
		//Metodo definido en la clase padre
		work.leer(); 
		System.out.println(work.toString());
		
		// Metodo sobrescirot en la clase Trabajador
		work.leer("Andres", "Ramon"); 
		System.out.println(work.toString());
	}

}
