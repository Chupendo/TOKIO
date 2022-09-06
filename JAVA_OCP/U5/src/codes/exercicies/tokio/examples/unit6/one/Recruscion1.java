package codes.exercicies.tokio.examples.unit6.one;

public class Recruscion1 {

	public static void main(String[] args) {
		int N = 3;
		//Calculo factorial de N
		factorial(N);

		//Calculo factorial rescursivo
		System.out.println("Facotrial de "+N+" = "+factorialR(N));
	}

	static void factorial(int n) {
		int resultado = 1; // Elemento neutro de la multiplicacion
		for(int i=1;i<=n;i++) {
			resultado = resultado * i;
		}
		System.out.println("Facotrial de "+n+" = "+resultado);
	}
	
	static int factorialR(int n) {
		int r=1;
		if(n==1) return 1; 
		else if(n>1) r=n*factorialR(n-1);
		return r;
	}
}
