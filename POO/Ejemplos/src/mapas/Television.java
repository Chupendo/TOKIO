package mapas;

public class Television {

    // ATRIBUTOS. Variables de instancia.
    public String marca;
    public int pulgadas;

    public Television(String marca, int pulgadas) {
        super();
        this.marca = marca;
        this.pulgadas = pulgadas;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Television [marca=");
        builder.append(marca);
        builder.append(", pulgadas=");
        builder.append(pulgadas);
        builder.append("]");
        return builder.toString();
    }
}
