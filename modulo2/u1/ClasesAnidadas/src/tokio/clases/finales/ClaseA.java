package tokio.clases.finales;

/**
 * ClaseA es una clase pública final
 * Las clases externas solo pueden ser:
 * - publica/default (package)
 * - final
 * 
 * No peuden ser estaticas y no aceptan otros tipos
 * de modificadores de acceso.
 *
 */
public final class ClaseA {
	public static final String  nameA = "Clase A final";
	
	/**
	 * La clase interna SubClaseANF es una clase 
	 * - pública
	 * - no estática
	 * - no final
	 * 
	 * Por lo tanto:
	 * 
	 * - Es una clase anónima que no puede ser
	 * usada como clase padre 
	 * 
	 * - Su existencia depende de la existencia de una instancia
	 * de la clase externa.
	 *
	 */
	public class SubClaseANF{
		public static final String  name = "Subclase Anonima no final de "+nameA;	
		public SubClaseANF() {
			System.out.println(this.name);
		}
	}
	
	/**
	 * La clase interna SubClaseANFS es una clase 
	 * - pública
	 * - estática
	 * - no final
	 * 
	 * Por lo tanto:
	 * 
	 * - Es una clase estática y puede ser
	 * usada como clase padre 
	 * 
	 * - Su existencia no depende de la existencia de una instancia
	 * de la clase externa.
	 *
	 */
	public static class SubClaseANFS{
		public static final String  name = "Subclase Estatica no final de "+nameA;	
		public SubClaseANFS() {
			System.out.println(this.name);
		}
	}
	
	/**
	 * La clase interna SubClaseANFS es una clase 
	 * - pública
	 * - estática
	 * - final
	 * 
	 * Por lo tanto:
	 * 
	 * - Es una clase estática y no puede ser
	 * usada como clase padre 
	 * 
	 * - Su existencia no depende de la existencia de una instancia
	 * de la clase externa.
	 *
	 */
	public static final class SubClaseFS{
		public static final String  name = "Subclase Estatica final de "+nameA;	
		public SubClaseFS() {
			System.out.println(this.name);
		}
	}
}
