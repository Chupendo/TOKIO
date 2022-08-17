package a6.m3;

public class Constantes {
	public static enum MATERIAS {
		Agua, Tierra, Aire;

		public static MATERIAS isMateria(String materia) {
			for (MATERIAS value : values()) {
				if (value.name().equals(materia)) {
					return value;
				}
			}
			return null;
		}
	}

	public static enum TIPO_NATURALEZA {
		HUMANA, MUERTA;

		public static TIPO_NATURALEZA isTipoNaturaleza(String tipoNaturaleza) {
			for (TIPO_NATURALEZA value : values()) {
				if (value.name().equals(tipoNaturaleza)) {
					return value;
				}
			}
			return null;
		}
	}

	public static enum ANIMAL {
		GATO, PERRO;

		public static ANIMAL isAnimal(String animal) {
			for (ANIMAL value : values()) {
				if (value.name().equals(animal)) {
					return value;
				}
			}
			return null;
		}
	}

	public static enum TIPOS_GATOS {
		PERSA, SIAMES, SPHYNX, COMUN_EUROPEO;

		public static TIPOS_GATOS isTiposGatos(String especie) {
			for (TIPOS_GATOS value : values()) {
				if (value.name().equals(especie)) {
					return value;
				}
			}
			return null;
		}
	}

}
