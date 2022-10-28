package example.three;

public class ByThree implements Series {
	int start;
	int val;
	int pre;
	
	ByThree(){
		start = 0;
		val = 0;
		pre = 2;
	}
	
	@Override
	public int getNext() {
		val += 2;
		pre = val +2;
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
	
	public int getPre() {
		return pre;
	}
}
