package codes.practises.m3.p5;

import java.util.Scanner;

import codes.practises.m3.p5.Constantes.GOLOSINA;

/**
	 *  En las fiestas de un barrio hay competiciones deportivas que premian el desempeño en ellas con cupones que luego puedes cambiar por golosinas. 
	 *  
	 *  Una barra de caramelo se puede cambiar por 10 cupones, y un chicle por 3 cupones.
	 *  
	 *  Escribe una clase CandyCalculator que tenga un método candyCalculatorque permita:
	 *  	1. Calcular, dado un número dado de cupones, cuantas barras de caramelo y chicles puedes obtener si gastas todos tus cupones en barras de caramelo primero, y utilizas los cupones restantes en chicles.
	 * 		2. También te tiene que devolver el número de cupones restantes que no puedes gastar.
	 * 		3. Devuelve los valores en un arrayen donde la posición [0] representa las barras de caramelo, la posición [1] los chicles y la posición [2] los cupones restantes.
	 * 
	 * 	publicstaticint[] candyCalculator(intnum_cupones) {
	 * 		//Código
	 */
public class M1_07_Andres_Ruiz_Penuela {

	public static void main(String[] args) {
		CandyCalculator cupones = new CandyCalculator();
		int[] resultado;
		GOLOSINA [] golosina = GOLOSINA.values();
		
		cupones.setCupones(capturarInt("Inserte el numero de cupones: "));
		resultado = cupones.calcularCambio();
		for(int i=0;i<resultado.length;i++) {
			if(i<(resultado.length-1))
				System.out.println(golosina[i]+": "+resultado[i]);
			else
				System.out.println("Le quedan: "+resultado[i]+" cupones");
		}
	}
	
	/**
	 * Metodo que dado un mensaje devuelve un String introducido por el usuario
	 * 
	 * @param msg Mensaje de tipo String introducido por el usuario
	 * @return resultado int introducido por el usuario
	 */
	public static String capturarString(String msg) {
		Scanner sc = new Scanner(System.in);
		String resultado;

		System.out.print(msg);
		resultado = sc.nextLine();

		return resultado;
	}

	/**
	 * Metodo que dado un mensaje devuelve un integer introducido por el usuario
	 * 
	 * @param msg Mensaje de tipo String introducido por el usuario
	 * @return resultado String introducido por el usuario
	 */
	public static int capturarInt(String msg) {
		int resultado = 0;
		while (true) {
			try {
				resultado = Integer.parseInt(capturarString(msg));
				if(resultado>=0)
					break;
				else
					System.err.println("No es un numero valido (debe ser >=0).");
			} catch (NumberFormatException ex) {
				System.err.println("No es un numero: " + ex);
				continue;
			}
		}
		return resultado;
	}
}
