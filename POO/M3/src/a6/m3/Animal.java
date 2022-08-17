package a6.m3;

import java.util.Arrays;
import java.util.List;

import a6.m3.Constantes.ANIMAL;
import a6.m3.Constantes.MATERIAS;
import a6.m3.Constantes.TIPO_NATURALEZA;

public class Animal extends Naturaleza {

	private ANIMAL tipoAnimal;
	protected boolean peligroExtincion = false;
	
	/** Constructores **/
	public Animal() {
		super();
	}

	public Animal(MATERIAS materia, TIPO_NATURALEZA tipoNaturaleza,ANIMAL tipoAnimal) {
		super();
		if(tipoNaturaleza.equals(Constantes.TIPO_NATURALEZA.HUMANA)) {
			this.setMateria(materia);
			this.setTipoNaturaleza(tipoNaturaleza);
			this.tipoAnimal = tipoAnimal;
		}else {
			this.tipoAnimal = null;
		}
		
	}

	public Animal(String materia, String tipoNaturaleza, String tipoAnimal) {
		super();
		if(tipoNaturaleza.equals(Constantes.TIPO_NATURALEZA.HUMANA)) {
			this.setMateria(Constantes.MATERIAS.isMateria(materia));
			this.setTipoNaturaleza(Constantes.TIPO_NATURALEZA.isTipoNaturaleza(tipoNaturaleza));
			this.tipoAnimal = ANIMAL.isAnimal(tipoAnimal);
		}else {
			this.tipoAnimal = null;
		}
	}
	/** Métodos Getters & Setters**/
	public ANIMAL getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(ANIMAL tipoAnimal) {
		this.tipoAnimal = this.tipoAnimal;
		List<ANIMAL> values = Arrays.asList(Constantes.ANIMAL.values());
		if(getTipoNaturaleza()!=null) {
			if(values.contains(tipoAnimal)&&getTipoNaturaleza().equals(TIPO_NATURALEZA.HUMANA))
				this.tipoAnimal = tipoAnimal;
		}
		
	}
	
	/** Métodos públicos **/
	public void estaEnPeligroExtincion(boolean is) {
		this.peligroExtincion = is;
	}
	public boolean estaEnPeligroExtincion() {
		return this.peligroExtincion;
	}
	@Override
	public String toString() {
		return "Animal [tipoAnimal=" + tipoAnimal + ", peligroExtincion=" + peligroExtincion + "]";
	}

	public boolean isEmpaty() {
	
		if ((this.tipoAnimal == null) || (this.getMateria() == null) || (this.getTipoNaturaleza() == null)) {
			return true;
		}
		return false;
	}
	
}
