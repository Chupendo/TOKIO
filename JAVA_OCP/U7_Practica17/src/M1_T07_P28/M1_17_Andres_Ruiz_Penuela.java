package M1_T07_P28;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class M1_17_Andres_Ruiz_Penuela {

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
        			+"\n5. Ordenacion nautal: Palo - Numero Ascendente."
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
	        		case 5:
	        			OrdNal();
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
	
	/**
	 * Ordenacion natural
	 * primero por palos (por orden de lista) 
	 * y luego por números (de forma ascendente)
	 */
	public static void OrdNal() {
		System.out.println("OrdNature");
		Comparator<Carta> com1 = (c1,c2) -> c1.getPalo().compareTo(c2.getPalo());
		Comparator<Carta> com2 = (c1,c2) -> {
			if(c1.getPalo().compareTo(c2.getPalo())==0) {
				return c1.compareTo(c2);
			}
			return 0;
		};
		
		Collections.sort(mazo.cartas,com1);//ord palo
		Collections.sort(mazo.cartas,com2);//ord number asc
		mostrar();
	}
}
