package a5.m3;

public class PC {
	public String modelo;
	protected int ram;
	int grafica;
	private Double price;


	public PC(String modelo, int ram, int grafica, Double price) {

		this.modelo = modelo;
		this.ram = ram;
		this.grafica = grafica;
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
}
