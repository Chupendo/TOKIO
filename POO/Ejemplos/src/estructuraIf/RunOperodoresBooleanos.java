package estructuraIf;

public class RunOperodoresBooleanos {

	private final static int NUMERO = 10;
	public static void main(String[] args) {
		/**
		 * OPERADORES RELACIONALES
		 *
		 * <	Menor que
		 * >	Mayor que
		 * ==	Igual
		 * !=	Distinto
		 * <=	Menor o igual
		 * >=	Mayor o igual
		 */
		
		if(NUMERO == 5) {
			System.out.println("NUMERO IGUAL A 5");
		}
		
		if(NUMERO !=4 ) {
			System.out.println("NUMERO DISTITNO A 4");
		}
		
		if(NUMERO <= 10 ) {
			System.out.println("NUMERO MENOR QUE 10");
		}
		
		if(NUMERO > 10) {
			System.out.println("NUMERO MAYOR QUE 10");
		}else{
			System.out.println("NUMERO MENOR QUE 10");
		}

	}

}
