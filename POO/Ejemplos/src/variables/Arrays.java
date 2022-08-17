package variables;

public class Arrays {
	public static void main(String[] args) {
		Car[] car = new Car[3];
		car[0] = new Car();
		car[1] = new Car();
		car[2] = new Car();
		System.out.println("N elementos de car= "+car.length);
		for(int i=0;i<car.length;i++) {
			System.out.println("i= "+i+", car.weith_clase= "+car[i].weith_clase+" car.weith_instance= "+car[i].weith_instance);
		}

		//EjemploWhile de excepción ArrayIndexOutOfBoundsException
		System.out.println("i= 3, car.weith_clase= "+car[3].weith_clase);
	}
}
