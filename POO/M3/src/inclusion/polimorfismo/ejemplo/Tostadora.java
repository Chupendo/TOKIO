package inclusion.polimorfismo.ejemplo;

public class Tostadora implements IElectrodomestico {

	private double consumo;
	private String marca;
	private boolean isReguladorTemperatura;
    private boolean isRanuraTostado;

	public Tostadora(int consumo, String marca) {
		super();
		this.consumo = consumo;
		this.marca = marca;
		this.isReguladorTemperatura = true;
		this.isRanuraTostado = true;

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
		return !(isReguladorTemperatura && isRanuraTostado);
	}

	public boolean isReguladorTemperatura() {
		return isReguladorTemperatura;
	}

	public void setReguladorTemperatura(boolean isReguladorTemperatura) {
		this.isReguladorTemperatura = isReguladorTemperatura;
	}

	public boolean isRanuraTostado() {
		return isRanuraTostado;
	}

	public void setRanuraTostado(boolean isRanuraTostado) {
		this.isRanuraTostado = isRanuraTostado;
	}
}