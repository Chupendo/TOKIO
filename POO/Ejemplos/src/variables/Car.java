package variables;

public class Car{
	public int weith_instance;
	public static int weith_clase=0;
	public Car() {
		this.weith_instance=this.weith_clase;
		this.weith_clase++;
	}
}