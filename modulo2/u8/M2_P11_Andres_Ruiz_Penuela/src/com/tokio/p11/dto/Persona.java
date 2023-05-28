package com.tokio.p11.dto;

public class Persona {
	protected String nombre;
	protected Identificacion docIdentificacion;
	protected String email;
	protected String telefono;
		
	public Persona(String nombre, Identificacion docIdentificacion, String email,
			String telefono) {
		this.nombre = nombre;
		this.docIdentificacion = docIdentificacion;
		this.email = email;
		this.telefono = telefono;
	}
	
	public Persona(Persona p) {
		this.nombre = p.getNombre();
		this.docIdentificacion = p.getDocIdentificacion();
		this.email = p.getEmail();
		this.telefono = p.getTelefono();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Identificacion getDocIdentificacion() {
		return docIdentificacion;
	}
	public void setDocIdentificacion(Identificacion docIdentificacion) {
		this.docIdentificacion = docIdentificacion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", docIdentificacion=" + docIdentificacion + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
	
	
}
