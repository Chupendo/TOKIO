package tokio.school.m2.p9.dto;

import java.util.Objects;

public class Ciudad implements Comparable<Ciudad> {
	
	protected String ciudad;
	protected String provincia;
	protected Long habitantes;
		
	public Ciudad(String ciudad, String provincia, Long habitantes) {
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.habitantes = habitantes;
	}
	
	public Ciudad(Ciudad ciudad) {
		this.ciudad = ciudad.getCiudad();
		this.provincia = ciudad.getProvincia();
		this.habitantes = ciudad.getHabitantes();
	}
	
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Long getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(Long habitantes) {
		this.habitantes = habitantes;
	}
	@Override
	public String toString() {
		return "Ciudad [ciudad=" + ciudad + ", provincia=" + provincia + ", habitantes=" + habitantes + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ciudad, habitantes, provincia);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudad other = (Ciudad) obj;
		return Objects.equals(ciudad, other.ciudad) && Objects.equals(habitantes, other.habitantes)
				&& Objects.equals(provincia, other.provincia);
	}

	@Override
	public int compareTo(Ciudad o) {
		return this.getCiudad().compareTo(o.getCiudad());
	}
	
	
}
