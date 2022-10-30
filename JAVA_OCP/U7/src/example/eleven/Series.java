package example.eleven;

public interface Series {
	int getNext(); // devolver el siguiente número de la serie
	void reset(); // reiniciar
	void setStart (int x); // definir valor inical
	
	default int[] skipAndGetNextArray(int skip, int n) {
		getArray(skip);
		return getArray(n);
	}
	//Este metodo se puede invocar como Series.getUniversaldID()
	//este metodo no puede ser hereado
	static int getUniversaldID() {
		return 0;
	}
	// Metodo privado que devuelve los siguientes n elmentos de una matriz
	private int[] getArray(int n) {
		int[] vals = new int [n];
		for(int i=0; i<n; i++) vals[i] = getNext();
		return vals;
	}
}
