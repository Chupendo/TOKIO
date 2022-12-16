package M1_T06_P23;

import java.util.Scanner;
import java.util.stream.Stream;

public class M1_14_Andres_Ruiz_Penuela {
	
	public static final byte NPERSONAL = 3; // Numero de personals en la lista
	public static Universidad uni = new Universidad();
	
	/**
	 * Meotod principal
	 * @param args
	 */
	public static void main(String[] args) {
		Personal[] lPersonal = null;
		
		// Inicializa la lista de personas
		if (NPERSONAL > 0) {
			lPersonal = new Personal[NPERSONAL];
			// Añade persnoal a la lista
			addPersonal(lPersonal);
		}else{
			System.err.println("El numero de personas debe ser mayoro que 0");
		}
		
		if (lPersonal != null && !isEmpaty(lPersonal)) {
			// Muestra las persnas de la lista
			System.out.println("Lista de personal:");
			Stream.of(lPersonal).forEach(person->{
				if(person!=null) {
					System.out.println(person);
				}
			});

			// Muestra las nominas de las personas en la lista
			System.out.println("Nominas: ");
			uni.imprimirNominas(lPersonal);
			
			// Muestra el prespueso de la univiersiad & restablce las horas extras a cero
			System.out.println("Presupuesto: "+uni.obtenerPresupuestoTotal(lPersonal)/(float)100+" Euros");
 
		} else {
			System.out.println("Lista de personal vacia");
		}
	}

	/**
	 * Meotod que comprueba si la lista de personas esta vacia o no
	 * 
	 * @param lPersonal
	 * @return boolean
	 * 	true si esta vacia, false en otro caso
	 */
	public static boolean isEmpaty(Personal[] lPersonal) {
		byte cont = 0;
		for (Personal person : lPersonal) {
			if (person != null) {
				cont++;
			}
		}
		return cont==0?true:false;
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
					}else {
						if(type <1 || type > 4) {
							System.out.println("Opcion no contempalda");
						}else {
							lPersonal[nPersonal] = addPerson(type);
						}
					}
					
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

	/**
	 * Metodo que devuelve la isnticia de un personal de la universidad encapsualdo en un tipo de Personal
	 * 
	 * @param type:byte
	 * 		Tipo de personal a añadir {1-Administrativo,2-Informatico,3-Profesor,4-Investigador}
	 * @return Personal
	 * 		Deuvelve una instancia de tipo personal
	 */
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
			if(!isDni(dni)) {
				System.err.println("Sinstas no valida.");
			}
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
					System.err.print("Error al insertar el dato: " + e);
					sc.next();
				}
			} while (true);
		}

		// Senios reconocidos
		if (type == 3) {
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

		// Se crea la instancia y se encapsula en un tipo Persona
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
			person = new Investigador(nombre, dni);
			break;
		}

		return person;
	}

	/**
	 * Metodo que valida la sintaxis del DNI
	 * 
	 * Sintaxis: [a-zA-Z]{1}\\d{8}
	 * 
	 * @param dni:String
	 * 	 	DNI a validar
	 * @return boolean
	 * 		true si cumple la sintaxis, false si no la cumple
	 */
	public static boolean isDni(String dni) {
		return dni.matches("[a-zA-Z]{1}\\d{8}") || dni.matches("\\d{8}[a-zA-Z]{1}");
	}

}
