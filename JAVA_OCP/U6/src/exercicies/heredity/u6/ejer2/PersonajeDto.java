package exercicies.heredity.u6.ejer2;

public class PersonajeDto {
	private String nombre;
	private String epoca;
	private short nivel;
	private float dinero;
	private CiudadDto ciudad;
	
	public PersonajeDto(String nombre, String epoca, CiudadDto ciudad) {
		super();
		this.nombre = nombre;
		this.epoca = epoca;
		this.nivel = 0;
		this.dinero = 500;
		this.ciudad = ciudad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEpoca() {
		return epoca;
	}
	public void setEpoca(String epoca) {
		this.epoca = epoca;
	}
	public short getNivel() {
		return nivel;
	}
	public void setNivel(short nivel) {
		this.nivel = nivel;
	}
	public float getDinero() {
		return dinero;
	}
	public void setDinero(float dinero) {
		this.dinero = dinero;
	}

	public CiudadDto getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadDto ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		if(ciudad==null) {
			return "PersonajeDto [nombre=" + nombre + ", epoca=" + epoca + ", nivel=" + nivel + ", dinero=" + dinero
					+ ", ciudad= void ]";
		}
		return "PersonajeDto [nombre=" + nombre + ", epoca=" + epoca + ", nivel=" + nivel + ", dinero=" + dinero
				+ ", ciudad=" + ciudad.toString() + "]";
	}
	
	
}
