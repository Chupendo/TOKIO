package excercio.queue;

// Cola FIFO de tamaño fijo para carecteres
public class FixedQueue implements ICharq {
	private char q[]; //matriz que contiene la cola
	private int putloc, getloc; //indices put y get
 
	//Crear una cola vaia de tamaño fijo
	public FixedQueue(int size) {
			q = new char[size+1]; //asigna memoria para la cola
								  //0 .. size
			putloc=getloc=0;
	}
	
	//Adir un caracter a la cola
	@Override
	public void put(char ch) throws QueueFullException {
		if(putloc==q.length-1) {
			System.out.println(" -- Que is full");
			throw new QueueFullException(q.length-1);
		}
		q[putloc++] = ch;
		
	}

	@Override
	public char get() throws QueeEmptyException {
		if(getloc==putloc) {
			System.out.println("-- Queue is empty");
			throw new QueeEmptyException();
		}
		return q[getloc++];

	}
}
