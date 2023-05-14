package lambda_1;

public class Persona {
	public enum GradoAcademico {ESO,BACHILLERATO, UNIVERSITARIO, BACHILLER, FP};
	private String nombre;
	private int edad;
	private GradoAcademico estudios;
	
	public Persona(String nombre, int edad, GradoAcademico estudios) {
		this.nombre = nombre;
		this.edad = edad;
		this.estudios = estudios;
	}
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public GradoAcademico getEstudios() {
		return estudios;
	}
	public void setEstudios(GradoAcademico estudios) {
		this.estudios = estudios;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", estudios=" + estudios + "]";
	}
	
	/**
	 * Si < 0, this es menor que p1
	 * Si > 0, this es mayor que p1
	 * Si = 0, this = que p1
	 * @param p1
	 * @return
	 */
	public int compararEdad(Persona p1) {
		return this.edad-p1.getEdad();
	}
	
	
}
