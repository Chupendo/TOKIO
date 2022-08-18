package codes.exercicies;

// Ilustra los números primos entre 2 y 100
public class Primos2to100 {

	public static void main(String[] args) {
		for (int i = 2; i <= 100; i++) {
			if (i == 1 || i == 2 || i == 3 || i == 5) {
				System.out.println(i + " es primo");
			} else {
				if ((i % 2 != 0) && (i % 3 != 0) && (i % 5 != 0))
					System.out.println(i + " es primo");
			}
		}
	}
}
