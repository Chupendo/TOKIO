package excercio.queue;

public class QueeEmptyException extends Exception{
	@Override
	public String toString() {
		return "\nQueue is Empty";
	}
}
