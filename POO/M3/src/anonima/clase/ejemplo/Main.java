package anonima.clase.ejemplo;

public class Main {

	public static void main(String[] args) {
		//Instancia de la clase A
		ClaseA objetoA = new ClaseA();
		
		//Clase anonima
		ClaseA claseAnonima = new ClaseA() {
			//Metodo sobrescrito
			@Override
			public int operarInt(int a, int b) {
				return a * b;
			}
			
			@Override
			public String toString() {
				return super.toString();
			}
		};
		
		//Uso de la clase A
		int resultado = objetoA.operarInt(3, 4);
		System.out.println("[Clase A] objetoA.operar(3,4): "+resultado);
		
		//Uso de la clase anónima
		resultado = claseAnonima.operarInt(3, 4);
		System.out.println("[Clase A] claseAnonima.operar(3,4): "+resultado);
		
	}
}
