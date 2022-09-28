package exercicies.heredity.u6.ejer1.dto;

public class Moto extends Vehiculo{
	private boolean carenado;
	private float peso;

	
	public Moto() {
		super();
	}

	public Moto(int numBastidor, String matricula, String modelo, char color, float kilometraje, boolean reparado, boolean carenado, float peso) {
		super(numBastidor, matricula, modelo, color, kilometraje, reparado);
		this.carenado = carenado;
		this.peso = peso;
	}

	public Moto(Vehiculo vh) {
		super(vh.getNumBastidor(), vh.getMatricula(), vh.getModelo(), vh.getColor(), vh.getKilometraje(), vh.isReparado());
	}


	public boolean isCarenado() {
		return carenado;
	}

	public void setCarenado(boolean carenado) {
		this.carenado = carenado;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Coche [id="+ getId()+" careanado=" + carenado +", peso= "+ peso + ", getNumBastidor()=" + getNumBastidor()
				+ ", getMatricula()=" + getMatricula() + ", getModelo()=" + getModelo() + ", getColor()=" + getColor()
				+ ", getKilometraje()=" + getKilometraje()  + ", reparado= " + isReparado() + "]";
	}
	
	
}
