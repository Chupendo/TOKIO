package a4.m3;

public class PC {
	private static Integer count = 0;
	private Integer id = 0;
	private String marca;
	private String modelo;
	private int ram;
	private int hd;
	
	/** Constructors **/
	public PC(String marca, String modelo, int ram, int hd) {
		this.marca = marca;
		this.modelo = modelo;
		this.ram = ram;
		this.hd = hd;
		this.count++;
		this.id = count;
	}
	public PC(String marca, String modelo, int ram, int hd,int id) {
		this.marca = marca;
		this.modelo = modelo;
		this.ram = ram;
		this.hd = hd;
		if(id>0&&id<count){//If update
			this.id = id;
		}else{//If new, count and id have to be synchronous
			this.count++;
			this.id = count;
		}
	}
	
	
	/** Getters & Setters**/
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getHd() {
		return hd;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}

	public Integer getId() {
		return this.id;
	}
	/** Methods Publics **/
	@Override
	public String toString() {
		return "PC [id="+ id +", marca=" + marca + ", modelo=" + modelo + ", ram=" + ram + ", hd=" + hd + "]";
	}
	public static Integer showLastId() {
		return count;
	}
	
}
