package M1_T08_P30;

import java.util.HashMap;
import java.util.Map;

import M1_T08_P30.ITeam.LANGUAGE;

public class M1_19_Andres_Ruiz_Penuela {

	public static void main(String[] args) {
		Map<String, Team> lTeam = new HashMap<String, Team>();
		TeamImp teamService = new TeamImp();

		// Creacion manual de Equipos
		lTeam.put("Full Programing Spain", new Team("Full Programing Spain", "University Jaen", LANGUAGE.PYTHON));
		lTeam.put("Full Programing America", new Team("Full Programing America", "University Cansas", LANGUAGE.JAVA));

		// Inicializa la lista de miembros de cada equipo
		do {
			try {
				teamService.initMember(lTeam.get("Full Programing Spain"));
				break;
			} catch (ExceptionFormatString | ExceptionLengthString e1) {
				e1.printStackTrace();
				continue;
			}
		} while (true);

		// Inicio del programama
		byte op = 0;
		do {
			//Solicitmoas una operacion a realizar
			String menu = ("Operaciones: " + "\n1. Crear Team." + "\n2. Agregar Miembro." + "\n3. Listar Equipos."
					+ "\n4. Salir" + "\nInsertar una opcion: ");
			op = teamService.getByte(menu);

			// Si la operacion es de salida
			if (op == 4) {
				System.out.println("Thanks! See you.");
				break;
			}

			switch (op) {
				case 1:
					System.out.println("New team");
					Team auxTeam = null;
					//Solicita un nuevo team y compreuba que no exita el nombre
					do {
						auxTeam = teamService.newTeam();
						if(lTeam.containsKey(auxTeam.name)) {
							System.out.println("Name Team in use");
							auxTeam = null;
						}
					} while (auxTeam == null);
					
					//Si no existe el nombre inializa la lista de miembros
					try {
						teamService.initMember(auxTeam);
						lTeam.put(auxTeam.name, auxTeam);
					} catch (ExceptionFormatString | ExceptionLengthString e) {
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("Add Member");
					String aKey[] = new String[lTeam.size()];
					byte n = -1;
					do {
						//Solicita que equipo quiere agregar el integrante o cancelar operarion
						do {
							n = 0;
							StringBuilder lNTeam = new StringBuilder("Indique un equipo: ");
							for (String k : lTeam.keySet()) {
								lNTeam.append("\n" + (n + 1) + ". " + k);
								aKey[n] = k;
								n++;
							}
	
							lNTeam.append("\n Inserte el indice correspondite al equipo (0 para salir)");
							n = -1;// clear
							n = teamService.getByte(lNTeam.toString());
	
							if (n < 0 || n > lTeam.size()) {
								System.out.println("Index not found.");
								n = 0;
							}
						} while (n < 0 || n > lTeam.size());
						
						
						if (n != 0) {
							//Solicita datos del integrante y lo añade
							try {
								teamService.addMember(lTeam.get(aKey[n - 1]));
								break;
							} catch (ExceptionFullTeam | ExceptionFormatString | ExceptionLengthString
									| NullPointerException e) {
								e.printStackTrace();
							}
						}else {
							//Se cancelo la operacion
							System.out.println("Cancel to add");
							break;
						}
	
					} while (true);
					break;
				case 3:
					System.out.println("Listar Equipos");
					//Muestra los datos un equipo
					lTeam.forEach((k, v) -> {
						int i = 0;
						System.out.println("Team: " + v.name);
						System.out.println("School: " + v.school);
						System.out.println("nMembers: " + v.nMembers);
						if (!v.lMembersEmpaty()) {
							teamService.printMember(v);
						}
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
					});
					break;
				default:
					System.out.println("Operation not found.");
					break;
			}
		} while (true);
	}
}
