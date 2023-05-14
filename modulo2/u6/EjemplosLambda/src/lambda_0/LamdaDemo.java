package lambda_0;

public class LamdaDemo {

	public static void main(String[] args) {
		// Declara una refernecia de interfaz
		Myvalue myVal; 
		
		// Ejemplo de una expresión lambada que devuelve una constante
		myVal = ()-> 89.6;
		
		// Invocar el método que proporciona la expresión lambda
		System.out.println("A constant value: "+ myVal.getValue());
		
		// Crear una expresión lambda con parámetros y asignarla a 
		// una referneica de interfaz.
		MyParamValue myPval = (n)-> 1.0/n; //Recíproco de n
		
		// Incovar getValue() a través de la referencia de interfaz
		System.out.println("Reciprocal of 4 is "+ myPval.getValue(4));
		System.out.println("Reciprocal of 8 is "+ myPval.getValue(8));
	}
	@FunctionalInterface
	public interface Myvalue{
		double getValue();
	}
	
	@FunctionalInterface
	public interface MyParamValue{
		double getValue(double v);
	}	
}
