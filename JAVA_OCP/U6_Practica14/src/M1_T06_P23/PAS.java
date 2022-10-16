package M1_T06_P23;

public class PAS extends Personal{
	
	//�Atributos?
	private static final byte PRECIOHORAEXTRA = 6;
	protected byte nHorasExtras;
	public PAS(String nombre, String dni, byte horasSemena, float precioHora,byte nHorasExtras,byte idCategoria) {
		super(nombre, dni, horasSemena, precioHora,idCategoria);
		this.nHorasExtras = nHorasExtras;
	}
	
	//�Constructor?
	
	//�M�todos?
	public float calcularSueldo() {
		float complemento = (nHorasExtras*PRECIOHORAEXTRA);
		nHorasExtras = 0;
		
		return this.salario+complemento;
	}
	
	public float calcularSueldoSinReset() {
		float complemento = (nHorasExtras*PRECIOHORAEXTRA);
		
		return this.salario+complemento;
	}

}
