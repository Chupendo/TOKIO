package com.mapper.dto;

public class PersonDTO {
	private static Integer id=0;
	private String nombre;
	private String apellidos;
	private int edad;

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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Integer getId() {
		return id;
	}
	public PersonDTO(String nombre, String apellidos, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public PersonDTO() {
		id++;
	}

	@Override
	public String toString() {
		return "PersonDTO [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + "]";
	}
	
	
}
