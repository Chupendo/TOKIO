package M1_T06_P23;

public class PDI extends Personal{
	
	private static final byte NSENIOSMAXIMOS = 6;
	private static final byte INCREMENTOPORSENIO = 100; 
	protected byte seniosReconocidos;

	public PDI(String nombre, String dni, byte horasSemena,float precioHora,byte seniosReconocidos,byte idCategoria) {
		super(nombre, dni, horasSemena, precioHora,idCategoria);
		this.seniosReconocidos = (seniosReconocidos>=0?(seniosReconocidos>NSENIOSMAXIMOS?NSENIOSMAXIMOS:seniosReconocidos):0);
	}
		
	/**
	 * Metodo que calcule el seudlo de un personal tipo PDI
	 * 
	 * @return float
	 * 	sueldo = salrio + ( senios * incrmento_por_senio )
	 */
	public float calcularSueldo() {
		
		return this.salario+(seniosReconocidos*INCREMENTOPORSENIO);
	}
}
