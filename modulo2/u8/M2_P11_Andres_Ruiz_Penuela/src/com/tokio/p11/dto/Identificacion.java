package com.tokio.p11.dto;

public class Identificacion {
	public static enum TIPO {DNI, NIE};
	protected TIPO tipo;
	protected String numIdentificacion;
	
	public Identificacion(TIPO tipo, String numIdentificacion) {
		super();
		this.tipo = tipo;
		this.numIdentificacion = numIdentificacion;
	}
	
	public TIPO getTipo() {
		return tipo;
	}
	public void setTipo(TIPO tipo) {
		this.tipo = tipo;
	}
	public String getNumIdentificacion() {
		return numIdentificacion;
	}
	public void setNumIdentificacion(String numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}
	@Override
	public String toString() {
		return "Identificacion [tipo=" + tipo + ", numIdentificacion=" + numIdentificacion + "]";
	}
}
