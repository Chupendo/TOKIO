package exercicies.heredity.u6.ejer2;

public class JugadroDto {
	private String nombre;
	private String apellidos;
	private String nick;
	private Long time;
	private PersonajeDto personaje;
	
		
	public JugadroDto(String nombre, String apellidos, String nick, Long time, PersonajeDto personaje) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nick = nick;
		this.time = time;
		this.personaje = personaje;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public PersonajeDto getPersonaje() {
		return personaje;
	}
	public void setPersonaje(PersonajeDto personaje) {
		this.personaje = personaje;
	}

	@Override
	public String toString() {
		if(personaje==null) {
			return "JugadroDto [nombre=" + nombre + ", apellidos=" + apellidos + ", nick=" + nick + ", time=" + time
					+ ", personaje= void]";
		}
		return "JugadroDto [nombre=" + nombre + ", apellidos=" + apellidos + ", nick=" + nick + ", time=" + time
				+ ", personaje=" + personaje.toString() + "]";
	}
	
	
}
