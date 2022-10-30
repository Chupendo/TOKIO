package example.nine;

public class SeriesIml implements Series, Series2 {

	@Override
	public int getNext() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
	}
	

	@Override
	public void setStart(int x) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setStart2(int x) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public int[] getNextArray(int n) {
		// TODO Auto-generated method stub
		return Series2.super.getNextArray(n);
	}

}
