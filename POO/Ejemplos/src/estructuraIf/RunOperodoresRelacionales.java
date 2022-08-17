package estructuraIf;

public class RunOperodoresRelacionales {

	public static void main(String[] args) {
		/**
		 * OPERADORES DE RELACIONALES
		 * 
		 * Nombre	|	Operador	|	Utilización	|	Resultado
		 * AND		|	&&			|	A && B		|	Verdadero si A y B son verdaderos. Evaluación condicional.
		 * OR		|	||			|	A || B		|	Verdadero si A o B son verdaderos. Evaluación condicional.
		 * NOT		!	!			|	!A			|	Verdadero si A es falso.
		 * AND		|	&			|	A & B		|	Verdadero cuando A y B son verdaderos. Evalúa ambos operadores.
		 * OR		|	|			|	A | B		|	Verdadero cuando A o B son verdaderos. Evalúa ambos operadores.
		 * XOR		|	^			|	A ^ B		|	Verdadero cuando A y B son diferentes.
		 */
		
		int numero=5;
		int numero2=8;
		String cadena = "HOLA";
		if(numero==5 && numero2==8) {
			System.out.println("numero==5 && numero2==8 IGUAL A TRUE");
		}
		
		if(numero==5 && numero2==9) {
			System.out.println("numero==5 && numero2==9 IGUAL A TRUE");
		}

		if(numero==5 || numero2==9) {
			System.out.println("numero==5 && numero2==8 IGUAL A TRUE");
		} 
		if(numero==5 || numero2==9) {
			System.out.println("numero==5 || numero2==9 IGUAL A TRUE");
		}
		
		if(numero==6 && numero2==9) {
			System.out.println("numero==6 && numero2==6 IGUAL A TRUE");
		}
		
		if(!"HOLA".equals(cadena)) {
			System.out.println("cadena difernente a \"HOlA\"");
		}else {
			System.out.println("cadena igual a \"HOlA\"");
		}

	}

}
