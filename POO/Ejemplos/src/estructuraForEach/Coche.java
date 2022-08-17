package estructuraForEach;

public class Coche {

    private String marca;
    private String modelo;
    private String color;

    public Coche(String marca, String modelo, String color) {
        super();
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Coche [marca=");
        builder.append(marca);
        builder.append(", modelo=");
        builder.append(modelo);
        builder.append(", color=");
        builder.append(color);
        builder.append("]");
        return builder.toString();
    }
    
}