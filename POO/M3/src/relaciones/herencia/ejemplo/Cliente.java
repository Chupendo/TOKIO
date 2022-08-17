package relaciones.herencia.ejemplo;

public class Cliente {
	private String nombre;
	private int dinero;

	public Cliente(String nombre, int dinero) {
		super();
		this.nombre = nombre;
		this.dinero = dinero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", dinero=" + dinero + "]";
	}
	
}
