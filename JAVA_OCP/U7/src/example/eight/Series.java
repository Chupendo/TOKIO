package example.eight;

public interface Series {
	int getNext(); // devolver el siguiente número de la serie
	void reset(); // reiniciar
	void setStart (int x); // definir valor inical
	
	// Devuelve una matriz que contegine los siguientes n elementos
	// de la serie más alal del elemento actual
	default int[] getNextArray(int n) {
		int[] vals = new int[n];
		
		for(int i = 0; i<n; i++) vals[i] = getNext();
		return vals;
	}
}
