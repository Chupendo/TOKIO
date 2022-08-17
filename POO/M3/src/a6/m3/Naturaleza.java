package a6.m3;

import java.util.Arrays;
import java.util.List;

import a6.m3.Constantes.ANIMAL;
import a6.m3.Constantes.MATERIAS;
import a6.m3.Constantes.TIPOS_GATOS;
import a6.m3.Constantes.TIPO_NATURALEZA;

public class Naturaleza {
	
	private MATERIAS materia;
	private TIPO_NATURALEZA tipoNaturaleza;

	/** Constructores **/
	public Naturaleza() {
	}

	public Naturaleza(MATERIAS materia, TIPO_NATURALEZA tipo) {
		this.materia = ((MATERIAS.valueOf(materia.toString())) != null) ? materia : null;
		this.tipoNaturaleza = ((TIPO_NATURALEZA.valueOf(tipo.toString())) != null) ? tipo : null;
	};

	public Naturaleza(String materia, String tipo) {
		MATERIAS.values();
		this.materia= MATERIAS.isMateria(materia);
		this.tipoNaturaleza= TIPO_NATURALEZA.isTipoNaturaleza(tipo);
	};

	
	/** Métodos Getters & Setters**/
	public MATERIAS getMateria() {
		return materia;
	}

	public void setMateria(MATERIAS materia) {
		this.materia = materia;
		List<MATERIAS> values = Arrays.asList(MATERIAS.values());
		if(values.contains(materia)) {
				this.materia = materia;
		}
	}

	public TIPO_NATURALEZA getTipoNaturaleza() {
		return tipoNaturaleza;
	}

	public void setTipoNaturaleza(TIPO_NATURALEZA tipoNaturaleza) {
		this.tipoNaturaleza = tipoNaturaleza;
		List<TIPO_NATURALEZA> values = Arrays.asList(TIPO_NATURALEZA.values());
		if(values.contains(tipoNaturaleza)) {
				this.tipoNaturaleza = tipoNaturaleza;
		}
	}


	/** Métodos públicos **/
	@Override
	public String toString() {
		return "Naturaleza [materia=" + this.materia + ", tipo=" + this.tipoNaturaleza + "]";
	}
	
	public boolean isEmpaty() {
		if ((this.materia == null) || (this.tipoNaturaleza == null)) {
			return true;
		}
		return false;
	}

}
