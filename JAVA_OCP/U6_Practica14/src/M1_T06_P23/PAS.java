package M1_T06_P23;

public abstract class PAS extends Personal{
	
	//Constantes de clase
	private static final byte PRECIOHORAEXTRA = 6;
	
	//Atributos de clase
	protected byte nHorasExtras;
	
	//Constructores
	public PAS(String nombre, String dni, byte horasSemena, int precioHora,byte nHorasExtras) {
		super(nombre, dni, horasSemena, precioHora);
		this.nHorasExtras = nHorasExtras;
	}
	
	
	/**
	 * Método que devuelve el salario del personal de tipo PAS
	 * restablece a 0 el numero de horas extras
	 * 
	 * @return float
	 * 	sueldo = salario + (numero_horas_extras * precio_hora_extra)
	 *
	 */
	public float calcularSueldo() {
		float complemento = (nHorasExtras*PRECIOHORAEXTRA);
		nHorasExtras = 0;
		
		return this.salario+complemento;
	}
	
	/**
	 * Método que devuelve el salario del personal de tipo PAS
	 * no restablce el numero de horas extras
	 * 
	 * @return float
	 * 	sueldo = salario + (numero_horas_extras * precio_hora_extra)
	 *
	 */
	public float calcularSueldoSinReset() {
		float complemento = (nHorasExtras*PRECIOHORAEXTRA);
		
		return this.salario+complemento;
	}
	
	@Override
	public String toString() {
		return super.toString()+", nHorasExtras= "+nHorasExtras ;
	}

}
