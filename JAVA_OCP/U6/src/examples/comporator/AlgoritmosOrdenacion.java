package examples.comporator;

public class AlgoritmosOrdenacion {
	
	/**
	 * Compara dos objetos de tipo string, e indica si str1 es mayor (>0), menor (<0) o igual (0) que 
	 * str2, según su código ASCII (Orden natural)
	 * 
	 *  See {@link <a href=https://www.javatpoint.com/java-ascii-table">Java ASCII Table</a>}.
	 *	See {@link AlgoritmosOrdenacion#compareStringAlf(String, String) }
	 * @param str1:String
	 * @param str2:String
	 * @return int
	 * 		>0 str1 tiene un codigo ASCII menor que str2 y por tanto str2>str1
	 * 		<0 str2 tiene un codigo ASCCI mayor que str1 y por tanto str2<str1
	 * 		=0 str2 tiene el mismo código ASCII que str1 y por tanto str2=str1
	 */
	public static int compareStringAlf(String str1,String str2) {
		return str1.compareTo(str2);
	}
	
	/**
	 * Compara dos objetos de tipo string, e indica si str2 es mayor (>0), menor (<0) o igual (0) que 
	 * str1, según su código ASCII (Orden natural invertido)
	 * 
	 *  See {@link <a href=https://www.javatpoint.com/java-ascii-table">Java ASCII Table</a>}.
	 *	See {@link AlgoritmosOrdenacion#compareStringAlf(String, String) }
	 *
	 * @param str1:String
	 * @param str2:String
	 * @return int
	 * 		>0 str2 tiene un codigo ASCII menor que str1 y por tanto str1>str2
	 * 		<0 str1 tiene un codigo ASCCI mayor que str2 y por tanto str1<str2
	 * 		=0 str1 tiene el mismo código ASCII que str2 y por tanto str1=str2
	 */
	public static int compareStringAlfInv(String str1,String str2) {
		return str2.compareTo(str2);
	}
}
