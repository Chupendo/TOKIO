package M1_T06_P25;

import java.util.Comparator;
import java.util.List;

public class OrdNumIncPal extends AlgoritmoOrdenacion {
	
	@Override
    public void ordena(List listaCartas) {
        // Algoritmos de ordenacion
		Comparator<Carta> comPalo = (carta1,carta2)->carta1.getPalo().compareTo(carta2.getPalo());
		Comparator<Carta> comNumero = (carta1,carta2)->carta1.getNumero().compareTo(carta2.getNumero());
		
		// Metodo sort de String, al implementar la intefaz Comparable
		listaCartas.sort(comNumero); // Comparacion por Numero de menor a mayor
		listaCartas.sort(comPalo); // Comparacion por Palo alfanumerico orden natural
    }

    public static int comparadorCarta(Carta c1, Carta c2) {
        // Comparador de cartas usado en el algoritmo de ordenaci�n
        return 0;
    }

}
