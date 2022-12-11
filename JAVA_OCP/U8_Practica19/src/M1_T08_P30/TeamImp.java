package M1_T08_P30;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TeamImp implements ITeam {
	// vairable para capturar datos por consola
	private static final Scanner SC = new Scanner(System.in);

	@Override
	public boolean teamFull(Team team) {
		return team.nMembers == MAX;
	}

	@Override
	public void initMember(Team team) throws ExceptionFormatString, ExceptionLengthString {
		char next = ' ';
		System.out.println("Inicializando lista de miembros del equipo " + team.name);
		do {
			if (team.nMembers == MAX)
				break;
			if (team.nMembers == MIN) {
				// añadir al 3º miembro
				next = getChar("Agregar otro miembro (S/N)");
				if (Character.compare(next, 'n') == 0 || Character.compare(next, 'N') == 0)
					break;
			}

			team.lMembers[team.nMembers] = newMember((byte) (team.nMembers + 1));
			team.nMembers++;

		} while (true);

	}

	@Override
	public void addMember(Team team) throws ExceptionFullTeam, ExceptionFormatString, ExceptionLengthString {
		if (teamFull(team))
			throw new ExceptionFullTeam();

		team.lMembers[team.nMembers] = newMember((byte) (team.nMembers + 1));
		team.nMembers++;

	}

	private static String getString(String msg) {
		String aux = "";
		do {
		System.out.print(msg + ": ");
		aux = SC.nextLine();
		}while(aux.length()==0 || aux.equals(" "));
		return aux;
	}

	public static byte getByte(String msg) {
		byte aux = 0;
		try {
			System.out.print(msg + ": ");
			aux = SC.nextByte();
		} catch (InputMismatchException e) {
			e.printStackTrace();
			SC.next();//clean buffer
		}
		return aux;
	}

	private LANGUAGE getLanguage(String msg) {
		String aux = "";
		byte n;
		do {
			n=1;
			System.out.print(msg + ": ");
			for (LANGUAGE languge : LANGUAGE.values()) {
				System.out.println("- "+languge);
			}
			aux = SC.nextLine();
			try {
				if (LANGUAGE.valueOf(aux) != null)
					break;
			}catch (IllegalArgumentException e) {
				e.printStackTrace();
			}

		} while (true);
		return LANGUAGE.valueOf(aux);

	}

	private char getChar(String msg) {
		char aux = ' ';
		do {
			aux = getString(msg).toCharArray()[0];
			if (Character.compare(aux, 'S') == 0 || Character.compare(aux, 's') == 0 || Character.compare(aux, 'N') == 0
					|| Character.compare(aux, 'n') == 0)
				break;
			else
				continue;
		} while (true);

		return aux;
	}

	private Member newMember(byte nMember) throws ExceptionFormatString, ExceptionLengthString {
		String name = "", surnameA = "", surnameB = "";
		name = getString("Inserte el nombre del miembro  [" + nMember + "]");
		surnameA = getString("Inserte el apellido uno  [" + nMember + "]");
		surnameB = getString("Inserte el aepellido dos  [" + nMember + "]");

		if (!textLengthMax(name) || !textLengthMax(surnameA) || !textLengthMax(surnameB))
			throw new ExceptionLengthString();
		if (!onlyText(name) || !onlyText(surnameA) || !onlyText(surnameB))
			throw new ExceptionFormatString();

		return new Member(name, surnameA, surnameB);
	}

	public Team newTeam() {
		String name = "", school = "";
		LANGUAGE language = null;

		name = getString("Inserte el equipo2");
		language = getLanguage("Inserte el lenguaje de programacion");
		school = getString("Inserte el nombre de la escuela");
		

		return new Team(name, school, language);
	}
}
