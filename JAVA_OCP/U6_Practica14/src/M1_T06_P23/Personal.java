package M1_T06_P23;

public class Personal {
	
	//Atributos
	private static final byte NSamanas = 4;
	private static enum CATEGORIA {INFORMATICO, ADMINISTRATIVO, PROFESORES, INVESTIGADORES;
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
	protected String nombre;
	protected String dni;
	protected float salario;
	protected CATEGORIA categoria;
	//�constructor?
	public Personal(String nombre, String dni,byte horasSemena,float precioHora,byte idCategoria) {
		this.nombre = nombre;
		this.dni = dni;
		this.salario = horasSemena* precioHora * NSamanas;
		this.categoria = CATEGORIA.getCategoria(idCategoria);
		
	}
	
	public String toString() {
		return "nombre: "+nombre+", salario: "+salario+" Eur., categoria: "+categoria;
	}
	
	public float calcularSueldo() {
		return this.salario;
	}
	
	
}
