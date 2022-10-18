package M1_T06_P25;

import java.util.List;

public abstract class AlgoritmoOrdenacion {
	
	 /**
     * Ordena una lista de cartas pasada por par�metro
     * @param listaCartas Lista de cartas que queda ordenada al final del algoritmo
     */
    public abstract void ordena(List listaCartas);
    
    public static int ordenarPalo(String paloC1,String paloC2) {
    	return paloC1.compareTo(paloC2);
    }
    
    public static int ordenarNumInc(int numeroC1,int numeroC2) {
    	return numeroC1-numeroC2;
    }
    
    public static int ordenarNumDec(int numeroC1,int numeroC2) {
    	return numeroC2-numeroC1;
    }

}
