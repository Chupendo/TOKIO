package exercicies.heredity.u6.ejer1.dto;

public class Vehiculo {
	private static int count = 1;
	private int id = 0;
	private int numBastidor;
	private String matricula;
	private String modelo;
	private char color;
	private float kilometraje;
	private boolean reparado;
	
	public Vehiculo() {
		this.id = count;
		this.count++;
	}

	public Vehiculo(int numBastidor, String matricula, String modelo, char color, float kilometraje, boolean repadado) {
		this();
		this.numBastidor = numBastidor;
		this.matricula = matricula;
		this.modelo = modelo;
		this.color = color;
		this.kilometraje = kilometraje;
		this.reparado = reparado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumBastidor() {
		return numBastidor;
	}

	public void setNumBastidor(int numBastidor) {
		this.numBastidor = numBastidor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public float getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(float kilometraje) {
		this.kilometraje = kilometraje;
	}

	
	public boolean isReparado() {
		return reparado;
	}

	public void setReparado(boolean reparado) {
		this.reparado = reparado;
	}

	@Override
	public String toString() {
		return "Vehiculo [id="+ id +", numBastidor=" + numBastidor + ", matricula=" + matricula + ", modelo=" + modelo + ", color="
				+ color + ", kilometraje=" + kilometraje + ", reparado= " + reparado + "]";
	}
 }
