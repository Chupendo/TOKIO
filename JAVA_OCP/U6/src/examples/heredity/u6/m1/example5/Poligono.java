package examples.heredity.u6.m1.example5;

public abstract  class Poligono {
	private int lados;

	public Poligono(int lados) {
		this.lados = lados;
	}

	public int getLados() {
		return lados;
	}

	public void setLados(int lados) {
		this.lados = lados;
	}

	// Declaración del método abstracto área
	public abstract double area();
}
