package inclusion.polimorfismo.ejemplo;

public class Lavadora implements IElectrodomestico {

	private double consumo;
	private String marca;
	private boolean isTambor;
	private boolean isPuerta;
	private boolean isConductoAgua;
	private boolean isMotor;

	public Lavadora(int consumo, String marca) {
		super();
		this.consumo = consumo;
		this.marca = marca;
		this.isTambor = true;
		this.isPuerta = true;
		this.isConductoAgua = true;
		this.isMotor = true;
	}

	@Override
	public double getConsumo() {
		return this.consumo;
	}

	@Override
	public void setConsumo(double consumo) {
		this.consumo = consumo;

	}

	@Override
	public String getMarca() {
		return this.marca;
	}

	@Override
	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public boolean isAveria() {
		return !(isTambor && isPuerta && isConductoAgua && isMotor);
	}

	public boolean isTambor() {
		return isTambor;
	}

	public void setTambor(boolean isTambor) {
		this.isTambor = isTambor;
	}

	public boolean isPuerta() {
		return isPuerta;
	}

	public void setPuerta(boolean isPuerta) {
		this.isPuerta = isPuerta;
	}

	public boolean isConductoAgua() {
		return isConductoAgua;
	}

	public void setConductoAgua(boolean isConductoAgua) {
		this.isConductoAgua = isConductoAgua;
	}

	public boolean isMotor() {
		return isMotor;
	}

	public void setMotor(boolean isMotor) {
		this.isMotor = isMotor;
	}
}
