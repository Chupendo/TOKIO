package a4.m3;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0.1
 */
public class Run {

	private static final String MENU;
	private static final String MENU2;
	static {
		MENU = "Sistema de PC:\n\t 1. Nuvo PC.\n\t 2. Modifciar PC.\n\t 3. Borrar.\n\t 4. Mostrar mapa.\nIndique una opcion (0 o \"Salir\" para salir): ";
		MENU2 = "Cambiar:\n\t 1. Modelo.\n\t 2. Marca.\n\t 3. RAM.\n\t 4. HD.\nIndique una opcion: ";
	}

	public static void main(String[] args) {
		// Declaracion de variables + inicialización
		Map<Integer, PC> mPC = new HashMap<Integer, PC>();
		Scanner sc = new Scanner(System.in);
		String option = "";

		do {
			// Mostramos el menu y capturamos la opcion
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
		} while (!(option.equals("0") || option.toLowerCase().equals("salir")));
	}

	/**
	 * MetodO mara mostrar el mapa de PC
	 * 
	 * @param mData:Map<Integer,pc>
	 */
	public static void showMapPC(Map mData) {
		if (!mData.isEmpty())
			mData.forEach((k, v) -> System.out.println(mData.get(k)));
		else
			System.err.println("No hay datos en el sistema.");

	}

	/**
	 * Metodo que agrega PC a un mapa
	 * 
	 * @param mData:Map<Integer,pc>
	 */
	public static void addPC(Map mData) {
		String name, modelo;
		int ram, hd;

		// Se solicitan los datos
		name = catchString("Inserte el nombre del PC: ");
		modelo = catchString("Inserte el modelo del PC: ");
		ram = catchInt("Inserte la ram: ");
		hd = catchInt("Inserte el hd: ");

		// Se agrega el nuevo equipo
		PC pc1 = new PC(name, modelo, ram, hd);
		mData.put(pc1.getId(), pc1);
		System.out.println("\tPC agregado.");
	}

	public static String catchString(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		return sc.nextLine();
	}

	/**
	 * Metodo que dlevuen un en valor numerico dado un String
	 * 
	 * @param msg
	 * 		  Mensaje de texto con informacion con la solicitud
	 * @return temporal
	 * 		  Valor numerico introducido por el usuario
	 */
	public static int catchInt(String msg) {
		boolean isInt = false;
		int temporal = 0;
		do {
			try {
				temporal = Integer.parseInt(catchString(msg));
				isInt = true;
			} catch (Exception e) {
				System.err.println("No es un valor numerico: " + e);
				isInt = false;
			}
		} while (!isInt);

		return temporal;
	}

	/**
	 * Metodo que acutlaza el valor de un PC del Mapa
	 * 
	 * @param mData:Map<Integer,pc>
	 */
	public static void updatePC(Map mData) throws NoSuchElementException, NoSuchElementException {
		Scanner sc = new Scanner(System.in);
		int elemId;
		short option;
		PC pc;
		if (!mData.isEmpty()) {
			do {
				System.out.println("PC en el sistema:");
				showMapPC(mData);
				elemId = catchInt("Indique el id del PC a modificar:");

				if (elemId <= 0 || elemId > PC.showLastId() || mData.get(elemId) == null)
					System.err.println("Opcion no valida");
				else {
					// PC modificado
					option = (short) catchInt(MENU2);
					pc = (PC) mData.get(elemId);
					switch (elemId) {
					case 1:
						pc.setMarca(catchString("Inserte la marca a reemplazar: "));
						break;
					case 2:
						pc.setModelo(catchString("Inserte la modelo a reemplazar: "));
						break;
					case 3:
						pc.setRam(catchInt("Inserte la Ram a reemplazar: "));
						break;
					case 4:
						pc.setHd(catchInt("Inserte el HD a reemplazar: "));
						break;
					}

					mData.put(elemId, pc);
					System.out.println("PC modificado.");
				}

			} while (elemId <= 0 || elemId > PC.showLastId());
		} else
			System.err.println("No hay datos en el sistema.");

	}

	/**
	 * Metodo que borrar un PC de un Mapa
	 * 
	 * @param mData
	 */
	public static void deletePC(Map mData) {
		int elem;
		if (!mData.isEmpty()) {
			do {
				System.out.println("PC en el sistema:");
				showMapPC(mData);
				elem = catchInt("Indique el id del PC a eliminar:");

				if (elem <= 0 || elem > PC.showLastId() || mData.get(elem) == null)
					System.err.println("Opcion no valida");
				else {
					// PC modificado
					mData.remove(elem);
					System.out.println("PC Borrado.");
				}

			} while (elem <= 0 || elem > PC.showLastId());
		} else
			System.err.println("No hay datos en el sistema.");
	}
}
