package a2.m3;

public class Table implements Forniture {

	private String model;
	private Double price;
	private int stock;
	
	public Table(String model, Double price, int stock) {
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
		// stock*price + 21% of stock*price
		return this.stock*this.price*1.21;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Table [model=" + model + ", price=" + price + ", stock=" + stock + "]";
	}

	
}
