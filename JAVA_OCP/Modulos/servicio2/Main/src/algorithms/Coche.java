package algorithms;


public class Coche implements Comparable<Coche> {
	public String name;
	
	public Coche(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Coche o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
