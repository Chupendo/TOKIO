package a6.m3;

import java.util.Arrays;
import java.util.List;

import a6.m3.Constantes.ANIMAL;
import a6.m3.Constantes.MATERIAS;
import a6.m3.Constantes.TIPOS_GATOS;
import a6.m3.Constantes.TIPO_NATURALEZA;

public class Gato extends Animal {

	private TIPOS_GATOS especie;
	public String name;

	/** Constructores **/
	public Gato() {
		super();
	}

	public Gato(MATERIAS materia, TIPO_NATURALEZA tipoNaturaleza, ANIMAL tipoAnimal, TIPOS_GATOS especie) {
		super();
		if (tipoNaturaleza.equals(Constantes.TIPO_NATURALEZA.HUMANA) && materia.equals(Constantes.MATERIAS.Tierra)
				&& tipoAnimal.equals(Constantes.ANIMAL.GATO)) {
			this.setMateria(materia);
			this.setTipoNaturaleza(tipoNaturaleza);
			this.setTipoAnimal(tipoAnimal);
			this.especie = especie;
		} else {
			this.especie = null;
		}

	}

	public Gato(String materia, String tipoNaturaleza, String tipoAnimal, String especie) {
		super();
		if (tipoNaturaleza.equals(Constantes.TIPO_NATURALEZA.HUMANA) && materia.equals(Constantes.MATERIAS.Tierra)
				&& tipoAnimal.equals(Constantes.ANIMAL.GATO)) {
			this.setMateria(Constantes.MATERIAS.isMateria(materia));
			this.setTipoNaturaleza(Constantes.TIPO_NATURALEZA.isTipoNaturaleza(tipoNaturaleza));
			this.setTipoAnimal(Constantes.ANIMAL.isAnimal(tipoAnimal));
			this.especie = Constantes.TIPOS_GATOS.isTiposGatos(especie);
		} else {
			this.especie = null;
		}

	}

	/** Métodos Getters & Setters **/
	public TIPOS_GATOS getEspecie() {
		return especie;
	}

	public void setEspecie(TIPOS_GATOS especie) {
		this.especie = this.especie;
		List<TIPOS_GATOS> values = Arrays.asList(TIPOS_GATOS.values());
		if (getTipoAnimal() != null && getTipoNaturaleza()!=null && getMateria()!=null) {
			if (values.contains(especie) && getTipoAnimal().equals(ANIMAL.GATO) && getMateria().equals(MATERIAS.Tierra)
					&& getTipoNaturaleza().equals(TIPO_NATURALEZA.HUMANA))
				this.especie = especie;
		}

	}

	/** Métodos públicos **/
	@Override
	public String toString() {
		return "Gato [especie=" + especie + ", name=" + name + "]";
	}

	public boolean isEmpaty() {

		if ((this.especie == null) || (this.getTipoAnimal() == null) || (this.getMateria() == null)
				|| (this.getTipoNaturaleza() == null)) {
			return true;
		}
		return false;
	}

}
