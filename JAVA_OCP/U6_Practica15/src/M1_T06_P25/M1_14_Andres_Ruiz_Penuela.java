package M1_T06_P25;

import java.util.Scanner;

public class M1_14_Andres_Ruiz_Penuela {

	static Baraja baraja = new Baraja();
	static Mazo mazo = baraja.getMazo();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		short op = 0;
        System.out.println(mazo.toString());
        do {
        	System.out.print("Operacione disponibles:"
        			+"\n1. Mostrar Baraja"
        			+"\n2. Ordenacion: Palo - Numero Incremento."
        			+"\n3. Ordenacion: Numero Incremento - Palo."
        			+"\n4. Ordenacion: Palo - Numero Decreciente."
        			+"\nOperacion a relizar (0 salir): ");
        	try {
        		op = sc.nextShort();
        		if(op==0) {
        			System.out.println("Adios");
        			break;
        		}
          		
        		switch (op) {
	        		case 1:
	        			mostrar();
						break;
	        		case 2:
	        			OrdPalNumInc();
						break;
	        		case 3:
	        			OrdNumIncPal();
						break;
	        		case 4:
	        			OrdPalNumDec();
						break;
					default:
						System.err.println("Operacion no permitida");
				}
        	}catch (Exception e) {
				System.err.println("Error al capturar el error: "+e);
				sc.next();
			}
        }while(true);
	}
	
	public static void mostrar() {
		System.out.println(mazo.toString());
	}

	public static void OrdPalNumDec() {
		System.out.println("OrdPalNumDec");
        mazo.setAlgoritmo(new OrdPalNumDec());
        mazo.ordena();
        mostrar();
	}
	
	public static void OrdPalNumInc() {
		System.out.println("OrdPalNumInc");
        mazo.setAlgoritmo(new OrdPalNumInc());
        mazo.ordena();
        mostrar();
	}
	
	public static void OrdNumIncPal() {
		System.out.println("OrdNumIncPal");
        mazo.setAlgoritmo(new OrdNumIncPal());
        mazo.ordena();
        mostrar();
	}
}
