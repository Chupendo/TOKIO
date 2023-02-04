package com.tokio.personas;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	protected String nombre;
	protected int edad;
	protected Date nacimiento;
	protected String nif;
	
	public Person(String nombre, int edad, Date nacimiento, String nif) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.nacimiento = nacimiento;
		this.nif = nif;
	}
	public Person() {
		// TODO Auto-generated constructor stub
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
	public Date getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	@Override
	public String toString() {
		return "Person [nombre=" + nombre + ", edad=" + edad + ", nacimiento=" + nacimiento + ", nif=" + nif + "]";
	}
	
	
}
