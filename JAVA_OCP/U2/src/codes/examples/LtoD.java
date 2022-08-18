package codes.examples;

// conversión implizita: De Long a Double
public class LtoD {

	public static void main(String[] args) {
		long L;
		double D;
		
		L = 100123285L;
		D = L; 	// conversión automática de long a double
		
		System.out.println("L and D: " + L + " " + D);
	}
}
