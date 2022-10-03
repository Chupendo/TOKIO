package exercicies.heredity.u6.ejer2;

public class CiudadDto {
	private String nombre;
	private short nivel;
	private int habitantes;
	private byte tipo;
	
	public CiudadDto(String nombre) {
		this.nombre = nombre;
		this.nivel = 0;
		this.habitantes = 0;
		this.tipo = 0;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public short getNivel() {
		return nivel;
	}

	public void setNivel(short nivel) {
		this.nivel = nivel;
	}

	public int getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}

	public byte getTipo() {
		return tipo;
	}

	public void setTipo(byte tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "CiudadDto [nombre=" + nombre + ", nivel=" + nivel + ", habitantes=" + habitantes + ", tipo=" + tipo
				+ "]";
	}
	
}
