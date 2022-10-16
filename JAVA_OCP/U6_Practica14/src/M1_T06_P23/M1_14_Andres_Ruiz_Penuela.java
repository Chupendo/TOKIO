package M1_T06_P23;

import java.util.Scanner;
import java.util.stream.Stream;

public class M1_14_Andres_Ruiz_Penuela {
	public static final byte NPERSONAL = 1;
	public static Universidad uni = new Universidad();
	public static void main(String[] args) {
		Personal[] lPersonal = null;
		if (NPERSONAL > 0) {
			lPersonal = new Personal[NPERSONAL];

			addPersonal(lPersonal);
		}else{
			System.err.println("El numero de personas debe ser mayoro que 0");
		}
		
		if (lPersonal != null && !isEmpaty(lPersonal)) {
			System.out.println("Lista de personal:");
			Stream.of(lPersonal).forEach(System.out::println);
			
			System.out.println("Nominas: ");
			uni.imprimirNominas(lPersonal);
			
			System.out.println("Presupuesto: "+uni.obtenerPresupuestoTotal(lPersonal));
 
		} else {
			System.out.println("Lista de personal vacia");
		}
	}

	public static boolean isEmpaty(Personal[] lPersonal) {
		boolean empaty = true;
		for (Personal person : lPersonal) {
			if (person != null) {
				empaty = false;
				break;
			}
		}
		return empaty;
	}

	public static void addPersonal(Personal[] lPersonal) {
		Scanner sc = new Scanner(System.in);
		byte type = 0, nPersonal = 0;

		if (lPersonal != null && lPersonal.length > 0) {
			do {
				System.out.println("Personal disponible: ");
				System.out.println("\t1. Administrativo.");
				System.out.println("\t2. Informatico.");
				System.out.println("\t3. Profesor.");
				System.out.println("\t4. Investigador.");
				System.out.print("Indque el tipo personal a agregar (0 salir): ");
				try {
					type = sc.nextByte();
					if (type == 0) {
						System.out.println("Adios, Personal añadidos: " + nPersonal);
						break;
					}
					lPersonal[nPersonal] = addPerson(type);
				} catch (Exception e) {
					System.err.println("Error con el dato insertado " + e);
					sc.next();
					type = 0;
				}
				if (lPersonal[nPersonal] != null)
					nPersonal++;

			} while (type < 1 && type > 4 || nPersonal < lPersonal.length);
		}
	}

	public static Personal addPerson(byte type) {
		Scanner sc = new Scanner(System.in);
		String nombre, dni;
		byte horasExtras = 0, seniosReconocidos = 0;
		Personal person = null;

		// Nombre de la persona
		System.out.print("Nombre: ");
		nombre = sc.nextLine();

		// DNI de la persona
		do {
			System.out.print("DNI: ");
			dni = sc.nextLine();
			System.out.println(dni + " is dni= " + isDni(dni));
		} while (!isDni(dni));

		// Horas extras
		if (type == 1 || type == 2) {
			do {
				System.out.print("Indique las horas extras: ");
				try {
					horasExtras = sc.nextByte();
					if (horasExtras >= 0) {
						break;
					}
				} catch (Exception e) {
					System.err.print("Error al isnertar el dato: " + e);
					sc.next();
				}
			} while (true);
		}

		// Senios reconocidos
		if (type == 3 || type == 4) {
			do {
				System.out.print("Indique los senios reconocidos: ");
				try {
					seniosReconocidos = sc.nextByte();
					if (seniosReconocidos >= 0) {
						break;
					}
				} catch (Exception e) {
					System.err.println("Error al isnertar el dato: " + e);
					sc.next();
				}
			} while (true);
		}

		// Se crea la instancia
		switch (type) {
		case 1:
			person = new Administrativo(nombre, dni, horasExtras);
			break;
		case 2:
			person = new Informatico(nombre, dni, horasExtras);
			break;
		case 3:
			person = new Profesor(nombre, dni, seniosReconocidos);
			break;
		case 4:
			person = new Investigador(nombre, dni, seniosReconocidos);
			break;
		}

		return person;
	}

	public static boolean isDni(String dni) {
		return dni.matches("[a-zA-Z]{1}\\d{8}") || dni.matches("\\d{8}[a-zA-Z]{1}");
	}

}
