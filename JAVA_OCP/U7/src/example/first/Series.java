package example.first;

public interface Series {
	int getNext(); // devolver el siguiente número de la serie
	void reset(); // reiniciar
	void setStart (int x); // definir valor inical
	
	//Este metodo se puede invocar como Series.getUniversaldID()
	//este metodo no puede ser hereado
	static int getUniversaldID() {
		return 0;
	}
}
