package M1_T07_P28;

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
      
	
	/**
	 * Metodo que intercambia dos objetos de una lista
	 * 
	 * @param listaCartas:List<Carta>
	 * 		Lista de elementos
	 * @param c1:Carta
	 * 		Objeto 1 a intercambiar
	 * @param c2:Carta
	 * 		Objeto 2 a intercambiar
	 * @param i:int
	 * 		Posicion del objeto 1
	 * @param j:int
	 * 		Posicion del objeto 2
	 */
	public static void swap(List listaCartas,Carta c1, Carta c2,int i, int j) {
		Carta pivote = new Carta(c1.getNumero(), c1.getPalo());
		listaCartas.remove(c1);
		listaCartas.add(i, new Carta(c2.getNumero(), c2.getPalo()));
		
		listaCartas.remove(j);
		listaCartas.add(j, pivote);
	}

}
