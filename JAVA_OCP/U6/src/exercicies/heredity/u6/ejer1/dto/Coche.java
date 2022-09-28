package exercicies.heredity.u6.ejer1.dto;

public class Coche extends Vehiculo{
	private float capacidadMaletero;

	
	public Coche() {
		super();
	}

	public Coche(int numBastidor, String matricula, String modelo, char color, boolean reparado, float kilometraje, float capacidadMaletero) {
		super(numBastidor, matricula, modelo, color, kilometraje, reparado);
		this.capacidadMaletero = capacidadMaletero;
	}
	
	public Coche(Vehiculo vh) {
		super(vh.getNumBastidor(), vh.getMatricula(), vh.getModelo(), vh.getColor(), vh.getKilometraje(), vh.isReparado());
	}

	public float getCapacidadMaletero() {
		return capacidadMaletero;
	}

	public void setCapacidadMaletero(float capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

	@Override
	public String toString() {
		return "Coche [id="+ getId()+" capacidadMaletero=" + capacidadMaletero + ", getNumBastidor()=" + getNumBastidor()
				+ ", getMatricula()=" + getMatricula() + ", getModelo()=" + getModelo() + ", getColor()=" + getColor()
				+ ", getKilometraje()=" + getKilometraje() + ", reparado= " + isReparado() + "]";
	}
	
	
}
