package a5.m3.parte2;

import a5.m3.PC;

public class Portatil extends PC {
	private Double bateria;
	
	/** Constructors**/
	public Portatil(String modelo, int ram, int grafica, Double price,Double bateria) {
		super(modelo,ram,grafica,price);
		this.bateria = bateria;
	}
	
	
	/**Getters && Setters**/
	public Double getBateria() {
		return bateria;
	}


	public void setBateria(Double bateria) {
		this.bateria = bateria;
	}

	/**Methods Publics**/
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("Sobresemsa [");
		msg.append("this modelo= "+this.modelo); 		//attr externo public
		msg.append("ram= "+this.ram);					//attr externo protected (!=package & class derivada)
		//msg.append("grafica= "+this.grafica);			//attr externo package/default (!= package)
		msg.append("price= "+this.getPrice());			//attr externo private
		msg.append("bateria"+this.bateria);				//attr interno private
		msg.append("]");
		return msg.toString();
	}
}
