package a2.m3;

public class Chair implements Forniture {

	private String model;
	private Double price;
	private int stock;
		
	public Chair(String model, Double price, int stock) {
		super();
		this.model = model;
		this.price = price;
		this.stock = stock;
	}

	@Override
	public String message() {
		return"Dispone del sigiuente stock"+this.stock;
	}

	@Override
	public Double calculate() {
		// stock*price + 10% of stock*price
		return this.stock*this.price*1.10;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Chair [model=" + model + ", price=" + price + ", stock=" + stock + "]";
	}

	
	
}
