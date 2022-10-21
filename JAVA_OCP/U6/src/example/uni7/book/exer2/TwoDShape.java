package example.uni7.book.exer2;

class TwoDShape {
	private double width;
	private double height;
	private String name;
	
	public TwoDShape() {
		width = height = 0.0;
		name = "none";
	}
	
	// Constructor con parametros
	public TwoDShape(double w,double h, String n) {
		this.width = w;
		this.height = h;
		this.name = n;
	}
	
	// Crear un objeto con la misma altura y anchura
	public TwoDShape(double x, String n) {
		this.width = this.height = x;
		this.name = n;
	}

	//Metodos de acceso para width y height
	public double getWidth() {	return width; }
	public void setWidth(double width) { this.width = width; }
	public double getHeight() {		return height;	}
	public void setHeight(double height) { 		this.height = height;	}

	public String getName() {
		return name;
	}

	void showDim() {
		System.out.println("Width and height are "+ width + " and "+ height);
	}
	
	double area() { //Metodo definido por TwoDShape
		System.out.println("area() must be overridden");
		return 0.0;
	}
}
