package exercicies.heredity.u6.ejer1.dto;

import java.util.ArrayList;
import java.util.List;

public class Mecanico {
	private String nombre;
	private String apellidos;
	private String email;
	private char especialidad;
	private int numReparaciones;
	private List<Vehiculo> lVehiculo;
	
	public Mecanico(String nombre, String apellidos, String email, char especialidad, int numReparaciones) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.especialidad = especialidad;
		this.numReparaciones = numReparaciones;
		this.lVehiculo = new ArrayList<Vehiculo>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(char especialidad) {
		this.especialidad = especialidad;
	}
	public int getNumReparaciones() {
		return numReparaciones;
	}
	public void setNumReparaciones(int numReparaciones) {
		this.numReparaciones = numReparaciones;
	}
	
	public List<Vehiculo> getlVehiculo() {
		return lVehiculo;
	}

	@Override
	public String toString() {
		return "Mecanico [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", especialidad="
				+ especialidad + ", numReparaciones=" + numReparaciones + "]";
	}
}
