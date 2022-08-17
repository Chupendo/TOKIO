package parametrico.polimorfismo.ejemplo;

public class Coche {
	public int velocidadKmh;

	public Coche(int velocdiadKmh) {
		this.velocidadKmh = velocdiadKmh;
	}
	
	public int velocidad() {
		return this.velocidadKmh;
	}
	
	public int velocidad(String unidad) {
		if("MH".equals(unidad)) {
			return this.velocidadKmh*1000;
		}
		return this.velocidadKmh;
	}
}
