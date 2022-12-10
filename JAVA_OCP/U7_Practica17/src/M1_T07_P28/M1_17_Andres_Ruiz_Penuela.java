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
        			+"\n2. Ordenacion: Palo Inceremento - Numero Incremento."
        			+"\n3. Ordenacion: Palo Inceremento - Numero Decremento."
        			+"\n4. Ordenacion: Palo Decremento - Numero Incremento."
        			+"\n5. Ordenacion: Palo Decremento - Numero Decremento."
        			+"\n6. Ordenacion: Numero Incremento - Palo Incremento."
        			+"\n7. Ordenacion: Numero Incremento - Palo Decremento."
        			+"\n8. Ordenacion: Numero Decremento - Palo Incremento."
        			+"\n9. Ordenacion: Numero Decremento - Palo Decremento."
        			+"\n10. Ordenacion nautal: Palo - Numero Ascendente."
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
	        			OrdPalIncNumInc();
						break;
	        		case 3:
	        			OrdPalIncNumDec();
						break;
	        		case 4:
	        			OrdPalDecNumInc();
						break;
	        		case 5:
	        			OrdPalDecNumDec();
						break;
	        		case 6:
	        			OrdNumIncPalInc();
						break;
	        		case 7:
	        			OrdNumIncPalDec();
						break;
	        		case 8:
	        			OrdNumDecPalInc();
						break;
	        		case 9:
	        			OrdNumDecPalDec();
						break;
	        		case 10:
	        			OrdNat();
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
	
	public static void OrdPalIncNumInc() {
		System.out.println("OrdPalIndNumInc");
		mazo.ordena(new  ComOrdPalDecNumInc());
        mostrar();
	}
	public static void OrdPalIncNumDec() {
		System.out.println("OrdPalIndNumDec");
		mazo.ordena(new  ComOrdPalDecNumDec());
        mostrar();
	}
	public static void OrdPalDecNumInc() {
		System.out.println("OrdPalDecNumInc");
		mazo.ordena(new  ComOrdPalDecNumInc());
        mostrar();
	}
	public static void OrdPalDecNumDec() {
		System.out.println("OrdPalDecNumDec");
		mazo.ordena(new  ComOrdPalDecNumDec());
        mostrar();
	}
	
	public static void OrdNumIncPalInc() {
		System.out.println("OrdNumIncPalInc");
        //Oredna numero menor a mayor y luego palo de menor a mayro
        mazo.ordena(new  ComOrdNumIncPalInc());
        mostrar();
	}
	public static void OrdNumIncPalDec() {
		System.out.println("OrdNumIncPalDec");
        //Oredna numero menor a mayor y luego palo de menor a mayro
        mazo.ordena(new  ComOrdNumIncPalDec());
        mostrar();
	}
	public static void OrdNumDecPalInc() {
		System.out.println("OrdNumDecPalInc");
        //Oredna numero menor a mayor y luego palo de menor a mayro
        mazo.ordena(new  ComOrdNumDecPalInc());
        mostrar();
	}
	public static void OrdNumDecPalDec() {
		System.out.println("OrdNumDecPalDec");
        //Oredna numero menor a mayor y luego palo de menor a mayro
        mazo.ordena(new  ComOrdNumDecPalDec());
        mostrar();
	}
	
	/**
	 * Ordenacion natural
	 * primero por palos (por orden de lista) 
	 * y luego por números (de forma ascendente)
	 */
	public static void OrdNat() {
		System.out.println("OrdNature");
		mazo.ordena();
		mostrar();
	}
}
