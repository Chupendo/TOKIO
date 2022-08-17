package a5.m3;

public class Sobremesa extends PC {
	private Integer alimentacion;

	/** Constructors**/
	public Sobremesa(String modelo, int ram, int grafica, Double price,Integer alimentacion) {
		super(modelo,ram,grafica,price);
		this.alimentacion = alimentacion;
	}
	
	/**Getters && Setters**/
	public Integer getAlimentacion() {
		return alimentacion;
	}


	public void setAlimentacion(Integer alimentacion) {
		this.alimentacion = alimentacion;
	}

	/**Methods Publics**/
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("Sobresemsa [");
		msg.append("this modelo= "+this.modelo); 		//attr externo public
		msg.append("ram= "+this.ram);					//attr externo protected (==package & class derivada)
		msg.append("grafica= "+this.grafica);			//attr externo package/default	(==package)
		msg.append("price= "+this.getPrice());			//attr externo private
		msg.append("alimentacion"+this.alimentacion);	//attr interno private
		msg.append("]");
		return msg.toString();
	}
}
