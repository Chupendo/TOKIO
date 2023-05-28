package com.tokio.p11.dto;

public interface ValidadorGenerico {
		boolean validar(String tipo,String Data) throws IllegalArgumentException;
}
