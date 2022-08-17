package a3.m3;

public class Employee extends Person implements IOperations {
	protected String identificaton;

	/** Constructors **/
	public Employee(String name, String surNames, int age, String identificaton) {
		super(name, surNames, age);
		this.identificaton = identificaton;
	}

	/** Methods Publics **/
	// Ejmeplo de poliformismo de sobrecarga: Sobreescrbie el método toString del
	// Padre
	@Override
	public String toString() {
		return super.toString() + " Employee [identificaton=" + identificaton + "]";
	}

	// Ejemplo de poliformismo de incursión: Implementa la operacion de la Interfaz
	// comun con la clase Client
	@Override
	public String msgWelcome() {
		return "Welcomen Employee number " + this.identificaton;
	}

}
