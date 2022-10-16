package M1_T06_P23;

public class Personal {

	// constantes de clase
	private static final byte NSemenas = 4;

	private static enum CATEGORIA {
		INFORMATICO, ADMINISTRATIVO, PROFESORES, INVESTIGADORES;

		private static CATEGORIA getCategoria(byte id) {
			CATEGORIA isCategoria;
			switch (id) {
			case 0:
				isCategoria = CATEGORIA.INFORMATICO;
				break;
			case 1:
				isCategoria = CATEGORIA.ADMINISTRATIVO;
				break;
			case 2:
				isCategoria = CATEGORIA.PROFESORES;
				break;
			case 3:
				isCategoria = CATEGORIA.INVESTIGADORES;
				break;
			default:
				isCategoria = null;
				break;
			}
			return isCategoria;
		}
	};

	// atributos de clase
	protected String nombre;
	protected String dni;
	protected float salario;
	protected CATEGORIA categoria;

	// �constructor
	public Personal(String nombre, String dni, byte horasSemena, float precioHora, byte idCategoria) {
		this.nombre = nombre;
		this.dni = dni;
		this.salario = horasSemena * precioHora * NSemenas;
		this.categoria = CATEGORIA.getCategoria(idCategoria);

	}

	/**
	 * Método que devuelve el vlaor de los atribtuos de la instancia mas relevantes
	 * 
	 * @return String
	 * 	mensaje con el nombre, salario y cateogira de la instancia de tipo persona
	 */
	public String toString() {
		return "nombre: " + nombre + ", salario: " + salario + " Eur., categoria: " + categoria;
	}

	/**
	 * Método que devuelve el salario del personal
	 * 
	 * @return float
	 * 	sueldo = salario = horas_semana * precio_hora * NSemenas
	 */
	public float calcularSueldo() {
		return this.salario;
	}

}
