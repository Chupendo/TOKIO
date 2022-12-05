package excercio.queue;

public class IQDemo {

	public static void main(String[] args) {
		FixedQueue q1 = new FixedQueue(10);
		
		ICharq iQ;
		char ch;
		int i;
		
		iQ = q1;
		//Aañidr caractres a la cola fija.
		for(i=0; i<11; i++) {
			try {
				iQ.put((char) ('A'+i));
			} catch (QueueFullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Mostrar la cola
		System.out.println("Contents of fixes queue: ");
		for(i=0;i<11; i++) {
			try {
				ch = iQ.get();
				System.out.print(ch);
			} catch (QueeEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println();

	}

}
