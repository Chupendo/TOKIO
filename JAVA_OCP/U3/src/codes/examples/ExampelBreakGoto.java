package codes.examples;

public class ExampelBreakGoto {

	public static void main(String[] args) {

		for (int i = 1; i < 3; i++) {
			one: {
				two: {

					if (i == 1)
						break one; // no finaliza el bucle, si no que salta o se dirige al final de la etiqueta one
					if(i==2)
						break two;
					//esto solo se imprimi si i >2
					System.out.println("Label 2");
				}// end label two
				System.out.println("Label 1");
			}// end label one
			System.out.println("Label 0");
			System.out.println("--------------");
		}
	}
}
