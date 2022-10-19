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
