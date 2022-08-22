package codes.practises.m3.p1;


public class Constantes {

	/**
	 * Enum con las asignaturas disponibles
	 * 
	 * @author Andres Ruiz Peñuela
	 *
	 */
	public static enum ASIGNATURA {
		Matetmaticas, Fisica, Quimica, Lenguaje, Historia;

		/**
		 * Comprueba si el String es una ASIGNATURA
		 * 
		 * @param asignatura
		 * 		 String a comprobar 
		 * @return resultado
		 * 		 true si asignatura, false en el caso contrario
		 */
		public static boolean esAsignatura(String asignatura) {
			boolean resultado = false;
			if (ASIGNATURA.valueOf(asignatura) != null) {
				resultado = true;
			}
			return resultado;
		}
		
		/**
		 * Numero de asignaturas diponibles
		 * 
		 * @return numero
		 * 		short con el numero de asignaturas
		 */
		public static short numeroAsignaturas() {
			short numero;
			numero = (short) Constantes.ASIGNATURA.values().length;
			return numero;
		}
		
		/**
		 * Devuelve un String con las opciones a mostrar
		 * @return menu
		 * 		String con el mensaje a mostrar para solicituar una asignatura
		 */
		public static String getMenuAsignaturas() {
			short contador = 0;
			ASIGNATURA[] asignatura = Constantes.ASIGNATURA.values();
			StringBuilder menu = new StringBuilder();
			menu.append("Lista de asignaturas: ");
			while(contador<asignatura.length) {
				menu.append("\n\t"+(contador+1)+". "+asignatura[contador]);
				contador++;
			}
			menu.append("\nSelecciona una asignatura (0 para salir y calcular la media): ");
			return menu.toString();
		}
		
		/**
		 * Devuelve una asigntura dado un numero
		 * 
		 * @param id
		 * 		 Short con el numero corresondiente de la asignatura
		 * 
		 * @return asignatura
		 *		ASIGNATURA equivlnete al numero recibido
		 */		
		public static ASIGNATURA getAsignatura(short id) {
			ASIGNATURA asignatura = null;
			switch (id) {
			case 1:
				asignatura = ASIGNATURA.Matetmaticas;
				break;
			case 2:
				asignatura = ASIGNATURA.Fisica;
				break;
			case 3:
				asignatura = ASIGNATURA.Quimica;
				break;
			case 4:
				asignatura = ASIGNATURA.Lenguaje;
				break;
			case 5:
				asignatura = ASIGNATURA.Historia;
				break;
			}
			
			return asignatura;
		}
	};

	/**
	 * Enum con las asiotasgnaturas disponibles
	 * 
	 * @author Andres Ruiz Peñuela
	 *
	 */
	public static enum NOTA {
		Muy_Deficiente, Insuficiente, Suficiente, Bien, Notable, Sobresaliente;

		public static boolean esNota(String nota) {
			boolean resultado = false;
			if (NOTA.valueOf(nota) != null) {
				resultado = true;
			}
			return resultado;
		}
		
		/**
		 * Comprueba si el String es una NOTA
		 * 
		 * @param nota
		 * 		 String a comprobar 
		 * @return resultado
		 * 		 true si nota, false en el caso contrario
		 */
		public static short numeroNotas() {
			short numero;
			numero = (short) Constantes.NOTA.values().length;
			return numero;
		}
		
		/**
		 * Dada una calificaicon devuelve la NOTA equivalente
		 * 
		 * @param nota
		 * 		 short calificacion a comprobar
		 * @return nota
		 * 		 NOTA equivalente 
		 */
		public static NOTA parserNota(short calificacion) {
			NOTA nota = null;
			switch (calificacion) {
			case 0:
			case 1:
			case 2:
				nota = NOTA.Muy_Deficiente;
				break;
			case 3:
			case 4:
				nota = NOTA.Insuficiente;
				break;
			case 5:
				nota = NOTA.Suficiente;
				break;
			case 6:
				nota = NOTA.Bien;
				break;
			case 7:
			case 8:
				nota = NOTA.Notable;
				break;
			case 9:
			case 10:
				nota = NOTA.Sobresaliente;
				break;
			}
			
			return nota;
		}
	};
}
