package com.tokio.p11.dto;



public class DataUtils {
	public static enum TIPO_VALID {
		DNI, NIE, EMAIL, PHONE
	};

	// BiPrecidado propio
	public static ValidadorGenerico validadorGenerico = (tipo, data)->{
		try {
			return validar(tipo, data);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
	};

	// Logica de validacion generico.
	private static boolean validar(String tipo, String valid)  throws IllegalArgumentException{
		boolean resul = false;
		String regex = "";
		try {
			switch (TIPO_VALID.valueOf(tipo.toString()).toString()) {
			case "DNI":
				regex = "^\\d{8}[a-z|A-Z]$";
				break;
			case "NIE":
				regex = "^[a-z|A-Z]\\d{8}";
				break;
			case "EMAIL":
				regex = "[\\w][^@|\\s]+@[\\w][^@|\\s]+\\.[a-z|A-Z]{2,}";
				break;
			case "PHONE":
				regex = "^[+]\\d{2}\\s{0,1}\\d{9}";
				break;
			}

			resul = valid.matches(regex);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
		return resul;
	}
}
