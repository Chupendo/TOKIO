package example.uni7.book.exer2;

public class Circle extends TwoDShape {
	/**
	 * Inicialia los datos de un circulo
	 * radio = with = hight
	 * 
	 * @param ratio: Double
	 */
	public Circle(double ratio) {
		super(ratio, "Circle");
	}
	
	/**
	 * Calcula el area de un circulo
	 * area = Pi * radio
	 */
	@Override
	double area() {
		return (Math.PI*Math.pow(getWidth(), 2));
	}
	
	double perimetre() {
		return (2*Math.PI*getWidth());
	}
}
