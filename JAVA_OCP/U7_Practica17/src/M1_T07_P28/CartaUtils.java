package M1_T07_P28;

public class CartaUtils {
	public static int transcript(String numero) {
		int resultado = 0;
		switch (numero.toUpperCase()) {
		case "AS":
			resultado = 1;
			break;
		case "DOS":
			resultado = 2;
			break;
		case "TRES":
			resultado = 3;
			break;
		case "CUATRO":
			resultado = 4;
			break;
		case "CINCO":
			resultado = 5;
			break;
		case "SEIS":
			resultado = 6;
			break;
		case "SIETE":
			resultado = 7;
			break;
		case "OCHO":
			resultado = 8;
			break;
		case "NUEVE":
			resultado = 9;
			break;
		case "SOTA":
			resultado = 10;
			break;
		case "CABALLO":
			resultado = 11;
			break;
		case "REY":
			resultado = 12;
			break;
		}
		return resultado;
	}
}
