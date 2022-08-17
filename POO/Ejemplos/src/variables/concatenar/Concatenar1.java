package variables.concatenar;

public class Concatenar1 {

	public static void main(String[] args) {
		String cadenaHola = "CADENA HOLA";
		String blank = " ";
		String nombre = args[0];

		String mensajeSalida = cadenaHola.concat(blank).concat(nombre);
		System.out.println(mensajeSalida);
	}

}
