package codes.exercicies.tokio.examples.unit4.one;

public class Vehicle {

	int passenger; 	//numero de pasajeros
	int fuelcap;	//capacidad de combustible en galones
	int mpg;		//consumo de combustible en millas por galon
	
	//Un constructor
	public Vehicle(int p,int f, int m) {
		passenger = p;
		fuelcap = f;
		mpg = m;
	}
	
	//Calcualr el combustilre para una determianda distancia
	double fuelneeded(int miles) {
		return (double) miles / mpg;
	}
}
