package M1_T08_P30;

import java.util.Arrays;


public interface ITeam {
	/** Lista de lengaujes de programacion disponibles */
	enum LANGUAGE { PYTHON, JAVA, CSAHP, JAVASCRIPT, CPLUS, RUBY, PHP, PASCAL, FORTRAN }
	/** Limite de parametros **/
	byte MAX = 3, MIN=2,limitString = 20;
	
	/**
	 * Comprueba si la lista de miembros esta llena
	 * @param team
	 * @return boolean truea si la lista esta llena
	 */
	boolean teamFull(Team team);
	/**
	 * Añade un miembro dado
	 * @param team
	 * @throws ExceptionFullTeam
	 * @throws ExceptionFormatString
	 * @throws ExceptionLengthString
	 * @see #MAX
	 */
	void addMember(Team team) throws ExceptionFullTeam, ExceptionFormatString, ExceptionLengthString;
	/**
	 * Inicializa la lista de miebmros de un equipo dado
	 * @param team
	 * @throws ExceptionFormatString
	 * @throws ExceptionLengthString
	 * @see #MAX
	 * @see #MIN
	 */
	void initMember(Team team) throws ExceptionFormatString, ExceptionLengthString;

	
	/**
	 * Comprueba que la longitud máxima no exceda del limit
	 * 
	 * @param value a comprobrar
	 * @return boolean true si value es menor que el limite establecido false resto de casos
	 * 
	 * @see #limitString
	 */
	public default boolean textLengthMax(String value) {
		return value.length()<limitString;
	}
	
	/**
	 * Comprueba que en el textno no contenga digitos (numeros)
	 * @param value
	 * @return boolean true si no hay digitos false el resto de casos
	 */
	public default boolean onlyText(String value) {
			
		return !value.codePoints()
			.filter( cp -> Character.isDigit(cp)).findFirst().isPresent();
	}
	
	/**
	 * Imprimie la lista de miembors de un equipo
	 * @param team
	 */
	default void printMember(Team team) {
		System.out.println("Members Team "+team.name);
		Arrays.stream(team.lMembers).forEach(System.out::println);
	}
}
