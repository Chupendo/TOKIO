package codes.exercicies.tokio.examples.unit4.one;

public class VehicleDemo {

	public static void main(String[] args) {
		Vehicle minvan = new Vehicle(7, 16, 21);
		Vehicle sportscar = new Vehicle(2, 14, 12);
		
		double gallons;
		int dist = 252;
		
		gallons = minvan.fuelneeded(dist);
		
		System.out.println("To go "+dist+" miles minivan needs "+
				gallons+" gallons of fuel.");
		
		gallons = sportscar.fuelneeded(dist);
		
		System.out.println("To go "+dist+" miles sportscar needs "+
				gallons+" gallons of fuel.");
		
	}

}
