package excercio.queue;

// Excepcion para errores de cola llena
public class QueueFullException extends Exception {
	int size;
	
	public QueueFullException(int s) {
		size = s;
	}
	
	@Override
	public String toString() {
		return "\nQueue is full. Maxium size is "+size;
	}
}
