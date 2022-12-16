package M1_T06_P23;

public abstract class PDI extends Personal{
	
	private static final byte NSENIOSMAXIMOS = 6;
	private static final byte INCREMENTOPORSENIO = 100; 
	protected byte seniosReconocidos=0;

	public PDI(String nombre, String dni, byte horasSemena,int precioHora, byte... seniosReconocidos) {
		super(nombre, dni, horasSemena, precioHora);
		if(seniosReconocidos!=null && seniosReconocidos.length==1) {
			this.seniosReconocidos = (seniosReconocidos[0]>=0?(seniosReconocidos[0]>NSENIOSMAXIMOS?NSENIOSMAXIMOS:seniosReconocidos[0]):0);
		}
	}
		
	/**
	 * Metodo que calcule el sueldo de un personal tipo PDI
	 * 
	 * @return float
	 * 	sueldo = salrio + ( senios * incrmento_por_senio )
	 */
	public float calcularSueldo() {
		if(seniosReconocidos!=0)
			return this.salario+(seniosReconocidos*INCREMENTOPORSENIO);
		else 
			return this.salario;
	}
	
	@Override
	public String toString() {
		
		if(seniosReconocidos!=0)
			return super.toString()+", seniosReconocidos= "+seniosReconocidos ;
		else 
			return super.toString();
	}
}
