package codes.examples;

// conversi�n implizita: De Long a Double
public class LtoD {

	public static void main(String[] args) {
		long L;
		double D;
		
		L = 100123285L;
		D = L; 	// conversi�n autom�tica de long a double
		
		System.out.println("L and D: " + L + " " + D);
	}
}
