package com.mapper.dto;

public class ClienteDTO {

	private String nombreCliente;
	private String apellidosCliente;

	public ClienteDTO(String nombreCliente, String apellidosCliente, int edad) {
		this.nombreCliente = nombreCliente;
		this.apellidosCliente = apellidosCliente;
	}

	public ClienteDTO() {
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidosCliente() {
		return apellidosCliente;
	}

	public void setApellidosCliente(String apellidosCliente) {
		this.apellidosCliente = apellidosCliente;
	}

	@Override
	public String toString() {
		return "ClienteDTO [nombreCliente=" + nombreCliente + ", apellidosCliente=" + apellidosCliente + "]";
	}

}
