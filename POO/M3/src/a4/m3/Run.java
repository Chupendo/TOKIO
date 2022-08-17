package a4.m3;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Run {

	private static final String MENU;
	static {
		MENU =  "Sistema de PC:\n\t 1. Nuvo PC.\n\t 2. Modifciar PC.\n\t 3. Borrar.\n\t 4. Mostrar mapa.\nIndique una opcion (0 o \"Salir\" para salir): ";
	}

	public static void main(String[] args) {
		// Declaracion de variables + inicialización
		Map<Integer, PC> mPC = new HashMap<Integer, PC>();
		Scanner sc = new Scanner(System.in);
		String option = "";
		
		do {
			//Mostramos el menu y capturamos la opcion
			System.out.print(MENU);
			option = sc.nextLine();
			System.out.println("--------------------------");
			switch (option) {
				case "0":
				case "Salir":
					System.out.println("Adios!");
					break;
				case "1":
					System.out.println("Agregar PC.");
					addPC(mPC);
					break;
				case "2":
					System.out.println("Modificar PC.");
					updatePC(mPC);
					break;
				case "3":
					System.out.println("Borrar PC.");
					deletePC(mPC);
					break;
				case "4":
					System.out.println("Mostrar map PC.");
					showMapPC(mPC);
					break;
				default:
					System.err.println("Opcion no disponible en el sistema.");
			}
		}while(!(option.equals("0")||option.toLowerCase().equals("salir")));
	}
	
	/**
	 * MetodO mara mostrar el mapa de PC
	 * 
	 * @param mData:Map<Integer,pc>
	 */
	public static void showMapPC(Map mData) {
		if(!mData.isEmpty())
			mData.forEach((k,v)->System.out.println( mData.get(k) ));
		else
			System.err.println("No hay datos en el sistema.");
		
	}
	
	/**
	 * Metodo que agrega PC a un mapa
	 * 
	 * @param mData:Map<Integer,pc>
	 */
	public static void addPC(Map mData) {
		PC pc1 = new PC("msi", "GL62 7RD", 1050, 250);
		mData.put(pc1.getId(),pc1);
		System.out.println("\tPC agregado.");
	}
	
	/**
	 * Metodo que acutlaza el valor de un PC del Mapa
	 * 
	 * @param mData:Map<Integer,pc>
	 */
	public static void updatePC(Map mData) {
		Scanner sc = new Scanner(System.in);
		Integer elem;
		if(!mData.isEmpty()) {
			do {
				System.out.println("PC en el sistema:");
				showMapPC(mData);
				System.out.print("Indique el id del PC a modificar:");
				try {
				elem = sc.nextInt();
				}catch(NoSuchElementException ex) {
					System.err.println("No es un valor numerico");
					sc.next(); //Aseguar que el buffer de teclado este limpio.
					elem = 0;
				}
				
				if(elem<=0||elem>PC.showLastId()||mData.get(elem)==null)
					System.err.println("Opcion no valida");
				else {
					//PC modificado
					
					PC pc = new PC("HP", "PAVILON", 1060, 500,elem);
					mData.put(elem,pc);
					System.out.println("PC modificado.");
				}
				
			}while(elem<=0||elem>PC.showLastId());
		}
		else
			System.err.println("No hay datos en el sistema.");
				
	}
	
	/**
	 * Metodo que borrar un PC de un Mapa
	 * 
	 * @param mData
	 */
	public static void deletePC(Map mData) {
		Scanner sc = new Scanner(System.in);
		Integer elem;
		if(!mData.isEmpty()) {
			do {
				System.out.println("PC en el sistema:");
				showMapPC(mData);
				System.out.print("Indique el id del PC a modificar:");
				try {
				elem = sc.nextInt();
				}catch(NoSuchElementException ex) {
					System.err.println("No es un valor numerico");
					sc.next(); //Aseguar que el buffer de teclado este limpio.
					elem = 0;
				}
				
				if(elem<=0||elem>PC.showLastId()||mData.get(elem)==null)
					System.err.println("Opcion no valida");
				else {
					//PC modificado
					mData.remove(elem);
					System.out.println("PC Borrado.");
				}
				
			}while(elem<=0||elem>PC.showLastId());
		}
		else
			System.err.println("No hay datos en el sistema.");
	}
}
