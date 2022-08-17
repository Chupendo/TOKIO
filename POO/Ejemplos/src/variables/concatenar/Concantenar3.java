package variables.concatenar;

public class Concantenar3 {

	public static void main(String[] args) {

	    String cadenaHola = "CADENA HOLA";
	    String blank = " ";
	    String nombre = args[0];

	    StringBuilder sb = new StringBuilder(cadenaHola);
	    sb.append(blank);
	    sb.append(nombre);

	}

}
