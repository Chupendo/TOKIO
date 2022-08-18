package codes.examples;


// El operador aritmético %
public class ModDemo {

	public static void main(String[] args) {
		int iresult, irem;
		double dresult, drem;
		
		iresult = 10 / 3; //cociente
		irem = 10 % 3;	  //resto
		
		dresult = 10 / 3; //cociente
		drem = 10 % 3;	  //resto
		
		System.out.println("Resultd and remainder of 10 / 3: c="+iresult+", r="+irem);
		System.out.println("Resultd and remainder of 10.0 / 3.0: c="+dresult+", r="+drem);
	}

}
