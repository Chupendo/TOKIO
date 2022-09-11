package codes.exercicies.tokio.activies.one;

import java.util.Date;

public class Electrodomestico {
	// Atributos
	private static long cont = 0;
	private long id;
	private Date garanty;
	private float weith;
	private String model;
	
	// Construcotres
	public Electrodomestico(Date date, float weith, String model) {
		cont++;
		this.id = cont;
		this.garanty = date;
		this.weith = weith;
		this.model = model;
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getGaranty() {
		return garanty;
	}

	public void setGaranty(Date garanty) {
		this.garanty = garanty;
	}

	public float getWeith() {
		return weith;
	}

	public void setWeith(float weith) {
		this.weith = weith;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	// method to String of Object class
	@Override
	public String toString() {
		return "Electrodomestico [id=" + id + ", garanty=" + garanty + ", weith=" + weith + ", model=" + model + "]";
	}
}
