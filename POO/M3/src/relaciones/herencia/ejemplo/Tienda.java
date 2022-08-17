package relaciones.herencia.ejemplo;

public class Tienda {
	private String nombre;
    private int planta;
    private int dimension;

    public Tienda(String nombre, int planta, int dimension) {
        super();
        this.nombre = nombre;
        this.planta = planta;
        this.dimension = dimension;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPlanta() {
        return planta;
    }
    public void setPlanta(int planta) {
        this.planta = planta;
    }
    public int getDimension() {
        return dimension;
    }
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
	@Override
	public String toString() {
		return "Tienda [nombre=" + nombre + ", planta=" + planta + ", dimension=" + dimension + "]";
	}
    
}
