package excercio.queue;

//Interfaz de cola de caractres
public interface ICharq {
	//Aañadir un carácter a la cola
	void put(char ch) throws QueueFullException;
	// Obtener un caracter de la cola
	char get() throws QueeEmptyException;
}
