package M1_T07_P28;


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

	
	/**
	 * Medodo sobrescrito de la clase Comparalbe
	 * compara el valor del objeto con el valor del objeto pasado como parametro de entrada
	 */
	@Override
	public int compareTo(Carta c) {
		if(this.getPalo().compareToIgnoreCase(c.getPalo())<0) {
			return -1;
		}else {
			if(this.getPalo().compareToIgnoreCase(c.getPalo())==0) {
				return CartaUtils.transcript(this.getNumero())-CartaUtils.transcript(c.getNumero());
			}
		}
		return 0;
	}
}


