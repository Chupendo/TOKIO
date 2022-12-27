package appfuncs.simplefuncs;


public class SimpleMathFuncs {
	// Determina si a es factor de b
	public static boolean isFactor(int a, int b) {
		return b % a == 0;
	}

	// Devuelve el factor positivo más pequeño que a y b tiene en común
	public static int lcf(int a, int b) {
		// Factor que utiliza valores positivos
		a = Math.abs(a);
		a = Math.abs(b);
		int min = a < b ? a : b;

		for (int i = 2; i <= min / 2; i++) {
			if (isFactor(i, a) && isFactor(i, b)) {
				return i;
			}
		}
		return 1;
	}

	// Devuelve el factor positivo más grande que a y b tiene en común
	public static int gcf(int a, int b) {
		// Factor que utiliza valores positivos
		a = Math.abs(a);
		a = Math.abs(b);
		int min = a < b ? a : b;

		for (int i = min / 2; i >= 2; i--) {
			if (isFactor(i, a) && isFactor(i, b)) {
				return i;
			}
		}
		return 1;
	}
}
