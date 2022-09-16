package codes.practises.two;

public class Rectangle {
	/** Base de la figura**/
	private double base;
	/** Altura de la figura**/
	private double tall;
	
	/**
	 * Constructor por defecto.
	 * 
	 * Asigna los valores {base,altura}={2,1}
	 */
	public Rectangle() {
		this.base = 2;
		this.tall = 1;
	}
	
	/**
	 * Inicializa un nuevo rectángulo con los valores pasados por parámetro
	 * 
	 * Si se intenta dar valor negativo a alguna de las dimensiones , lo corrige al valor positivo usando 
	 * @{link {@link codes.practises.two.Rectangle#absDouble(double) absDouble}
	 * 
	 * @param base
	 * 		double, base de la figura
	 * @param tall
	 * 		double, altura de la figura
	 * 

	 */
	
	public Rectangle(double base, double tall) {
		this.base = (base<0)?absDouble(base):base;
		this.tall = (tall<0)?absDouble(tall):tall;
	}
	
	/**
	 * Método que indica si la figura es un cuadrado
	 * 
	 * @return boolean
	 * 		true si es cuadrado, false en caso contrario
	 */
	public boolean isSquare() {
		return this.base==this.tall?true:false;
	}
	
	/**
	 * Método que calcula el áera de un cuadrado/rectángulo
	 * Operación: base*altura 
	 *
	 * @return double
	 * 		Área de la figura
	 */
	public double area() {
		return this.base*this.tall;
	}
	
	/**
	 * Método que calcúla el perímetro de un cuadrado/rectángulo
	 * 
	 * Operación:
	 * <ul>
	 * <li>Cuadrado: 2*lado</li>
	 * <li>Rectángulo: 2*(base+altura)</li>
	 * </ul>
	 * 
	 * @return double
	 * 		Perímetro de un cuadrado/rectángulo
	 */
	public double perimetrer() {
		return isSquare()?2*this.base:2*(this.base+this.tall);
	}
	
	/**
	 * Método que gira 90 grados la figura (giro isométrico) 
	 *
	 * Se realiza el cambio de la base por la altura.<br>
	 * 
	 * <i>Example:</i>
	 * <code>
	 * base=2; altura=1;<br> 
	 * double aux 	= base;		= 2;<br>
	 * base 		= altura	= 1;<br>
	 * altura		= aux		= 2;<br>
	 * </code>
	 */
	public void rotateIsometric() {
		double aux = this.base;
		this.base = this.tall; 
		this.tall = aux; 
	}
	
	/**
	 * Método que obtiente el valor absoluto de un numero
	 * 
	 * Usa la función {@link java.lang.Math#abs(double) abs}
	 * para obtener el valor absoluto.
	 * 
	 * @param number
	 * 		Double, numero a obtener valor absoluto
	 *  
	 * @return Dobule 
	 * 		Numero mayor o igual que cero
	 */
	private static double absDouble(double number) {
		return Math.abs(number);
	}

	/**
	 * Método que devuelve un mensaje de texto con los datos de la figura
	 * 
	 * return String
	 * 		Mensaje de texto con los valores de la instanica
	 */
	@Override
	public String toString() {
		return "Rectangle [base=" + base + ", tall=" + tall + "]";
	}

	
}
