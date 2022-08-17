package a2.m3;

public class Run {

	public static void main(String[] args) {
		Chair chair = new Chair("Forest", 135.2, 5);
		Table table = new Table("Gouchi", 1535.2, 2);
		
		System.out.println(chair.toString());
		System.out.println(table.toString());
		
		//Uso de una operación definida en la interfaz
		chair.message();
		table.message();
		
		//Us de una operación definida en la interfaz
		System.out.println("Inversión of chairs: "+chair.calculate()+ "€");
		System.out.println("Inversión of tables: "+table.calculate()+ "€");
		
		

	}

}
