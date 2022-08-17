package a2.m3;

public class Run {

	public static void main(String[] args) {
		Chair chair = new Chair("Forest", 135.2, 5);
		Table table = new Table("Gouchi", 1535.2, 2);
		
		System.out.println(chair.toString());
		System.out.println(table.toString());
		
		//Uso de una operaci�n definida en la interfaz
		chair.message();
		table.message();
		
		//Us de una operaci�n definida en la interfaz
		System.out.println("Inversi�n of chairs: "+chair.calculate()+ "�");
		System.out.println("Inversi�n of tables: "+table.calculate()+ "�");
		
		

	}

}
