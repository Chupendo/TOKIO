package com.tokio.lista;

public class Persona implements Comparable<Persona> {
	public enum ESTUDIOS {ESO,FPM,FPS,UNIVERSIDAD,BACHILLER};
	private String nombre;
	private int edad;
	private ESTUDIOS formacion;
	
	public Persona(String nombre, int edad, ESTUDIOS formacion) {
		this.nombre = nombre;
		this.edad = edad;
		this.formacion = formacion;
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

	public ESTUDIOS getFormacion() {
		return formacion;
	}

	public void setFormacion(ESTUDIOS formacion) {
		this.formacion = formacion;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", formacion=" + formacion + "]";
	}

	@Override
	public int compareTo(Persona o) {
		return this.getEdad()-o.getEdad();
	}
	
	
}
