package M1_T07_P28;

import java.util.Comparator;

public class Carta implements Comparable<Carta> {
	
	private final String numero;
    private final String palo;

    public Carta(String numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @return the palo
     */
    public String getPalo() {
        return palo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        hash = 47 * hash + (this.palo != null ? this.palo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.palo != other.palo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numero + " " + palo;
    }

	public static int transcript(String numero) {
		int resultado = 0;
		switch (numero.toUpperCase()) {
		case "AS":
			resultado = 1;
			break;
		case "DOS":
			resultado = 2;
			break;
		case "TRES":
			resultado = 3;
			break;
		case "CUATRO":
			resultado = 4;
			break;
		case "CINCO":
			resultado = 5;
			break;
		case "SEIS":
			resultado = 6;
			break;
		case "SIETE":
			resultado = 7;
			break;
		case "OCHO":
			resultado = 8;
			break;
		case "NUEVE":
			resultado = 9;
			break;
		case "SOTA":
			resultado = 10;
			break;
		case "CABALLO":
			resultado = 11;
			break;
		case "REY":
			resultado = 12;
			break;
		}
		return resultado;
	}

	/**
	 * Medodo sobrescrito de la clase Comparalbe
	 * compara el vlaor del objeto con el valor del objeto pasado como parametro de entrada
	 */
	@Override
	public int compareTo(Carta c) {
		return transcript(this.getNumero())-transcript(c.getNumero());
	}
}



