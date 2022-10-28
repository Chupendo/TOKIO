package example.three;

public class ByTwos implements Series {
	int start;
	int val;
	
	ByTwos(){
		start = 0;
		val = 0;
	}
	
	@Override
	public int getNext() {
		val += 2;
		return val;
	}

	@Override
	public void reset() {
		val = start;

	}

	@Override
	public void setStart(int x) {
		start = x;
		val = x;
	}
}
