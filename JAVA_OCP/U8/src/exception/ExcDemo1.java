package exception;

import java.util.Random;

public class ExcDemo1 {

	private static final int NBITS = 256;

	public static void main(String[] args) {
		String key[] = new String[4];
		
		try {// Se crea el bloque try
			System.out.println("Before exception is generated.");
			
			for(int i=0;i<key.length;i++) {
				key[i] = stringToSeed(NBITS);
			}

			System.out.println("generatedPWD: "  );
			for(int i=0;i<=key.length;i++) {
				System.out.println("key["+i+"]= "+key[i]);
			}
			
		} catch (ArrayIndexOutOfBoundsException exc) {// Capturar errores de límites de matriz.
			// capturar la excepcion
			System.err.println("Index out-of-bounds!");
		}
		System.out.println("After catch statement.");

	}

	/**
	 * Genera una String de nBits aleatorio
	 * 
	 * @param nBits
	 * @return String
	 * 		Cadena de texto aleatoria
	 */
	static String stringToSeed(int nBits) {
		//Code ASCCI
		int leftLimit = 33; // letter '!'
	    int rightLimit = 175; // letter '>>'
	    int targetStringLength = nBits/8; //A char is 8 bits
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    //System.out.println(generatedString);
	    return generatedString;
	}
}
