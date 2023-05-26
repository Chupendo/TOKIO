package lambda_6;

public class Persona {

	public String name;
	public String surname;
	public Integer edad;
	
	public Persona() {}
	public Persona(String name, String surname, int edad) {
		this.name = name;
		this.surname = surname;
		this.edad = edad;
	}
	
	public static String fullName(Persona persona) {
		return persona.name + " " + persona.surname;
	} 
	
	public boolean isMayor() {
		return this.edad>=18;
	}
	@Override
	public String toString() {
		return "Persona [name=" + name + ", surname=" + surname + ", edad=" + edad + "]";
	}
}
