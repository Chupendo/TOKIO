package a3.m3;

public class Client extends Person implements IOperations {
	private int number;

	/** Constructors **/
	// Ejemplo de poliformismo paramétrico
	public Client(String name, String surNames, int age, int number) {
		super(name, surNames, age);
		this.number = number;
	}

	public Client(String name, String surNames, int age) {
		super(name, surNames, age);
		this.number = 0;
	}

	/** Getters and Setters **/
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	/** Methods Publics **/
	// Ejmeplo de poliformismo de sobrecarga: Sobrescribre el método toString del
	// Padre
	@Override
	public String toString() {
		return super.toString() + " Client [number=" + number + "]";
	}

	// Ejemplo de poliformismo de incursión: Implementa la operacion de la Interfaz
	// comun con la clase Employeed
	@Override
	public String msgWelcome() {
		if(this.number!=0) {
			return "Welcomen Client number " + this.number;
		}
		return "Welcomen! Please, register you in the list ";	
	}
}
