package a1.m3.parte2;

import java.util.HashMap;
import java.util.Map;

import a1.m3.Table;

public class Run {

	//Mensajes a mostrar
		public static final Map<Integer, String> MESSAGES;
		static {
			MESSAGES = new HashMap<Integer, String>();
			MESSAGES.put(-1, "Mesa dos es la grande.");
			MESSAGES.put(0, "Mesas iguales.");
			MESSAGES.put(1, "Mesa uno es la grande.");
		}

		public static void main(String[] args) {
			// Declaracion e instancia de dos mesas
			Table t1 = new Table();
			Table t2 = new Table(3.2, false);

			// Mostramos valores iniciales
			System.out.println("---------------------------------------------");
			System.out.println("Valores Iniciales:");
			System.out.println("---------------------------------------------");		
			//System.out.println("¿Mesa 1 es redonda?: " + t1.isRoundTable); //Esto da error no se porque no esta en el mismo paquete
			System.out.println("Radio/Longiud del lado de la mesa 1: " + t1.getLength());
			System.out.println(t1.toString());

			//System.out.println("¿Mesa 2 es redonda?: " + t2.isRoundTable);
			//System.out.println("Radio/Longiud del lado de la mesa 2: " + t2.getLength()); //Esto da error no se porque no esta en el mismo paquete
			System.out.println(t2.toString());
			
			//Identificar la mesa mas grande
			try {			
				System.out.println("Intento 1: ");
				System.out.println("¿Comparar el area de las mesas? "
						+ MESSAGES.get(Table.compareToArea(t1.getLength(), t2.getLength())));

			} catch (NullPointerException ex) {
				System.err.println("[Run] Un objeto no esta inicializado");
			}finally {
				//Modificar longitud de una mesa
				t1.setLength(2.0); //seteamos lonigtud de la mesa (si es rendona => length=radio
				//t2.isRoundTable=!t2.isRoundTable; //Esto da error no se porque no esta en el mismo paquete
			}

	
			//Mostramos valores nuevamente
			System.out.println("---------------------------------------------");
			System.out.println("Valores Modificados:");
			System.out.println("---------------------------------------------");
			//System.out.println("¿Mesa 1 es redonda?: " + t1.isRoundTable);//Esto da error no se porque no esta en el mismo paquete
			System.out.println("Radio/Longiud del lado de la mesa 1: " + t1.getLength());
			System.out.println(t1.toString());

			//System.out.println("¿Mesa 2 es redonda?: " + t2.isRoundTable);//Esto da error no se porque no esta en el mismo paquete
			System.out.println("Radio/Longiud del lado de la mesa 2: " + t2.getLength());
			System.out.println(t2.toString());
			
			//Identificar la mesa mas grande
			try {
				System.out.println("Intento 2: ");
				System.out.println("¿Comparar el area de las mesas? "
						+ MESSAGES.get(Table.compareToArea(t1.getLength(), t2.getLength())));
			} catch (NullPointerException ex) {
				System.err.println("[Run] Un objeto no esta inicializado");
			}
		}

}
