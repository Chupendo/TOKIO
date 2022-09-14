package codes.exercicies.tokio.activies.five;

import java.util.Map;

import codes.exercicies.tokio.activies.five.Key.OBJECT;

public class Back {
	public final static int LIMIT_OBJECT = 99;
	public int capacity;
	public Map<OBJECT, Integer> objec;
	
	public Back(int capacity, Map<OBJECT, Integer> objec) {
		super();
		this.capacity = capacity;
		this.objec = objec;
	}
	
}
