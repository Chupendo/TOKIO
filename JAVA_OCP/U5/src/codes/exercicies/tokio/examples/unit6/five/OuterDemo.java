package codes.exercicies.tokio.examples.unit6.five;

public class OuterDemo {

	public static void main(String[] args) {
		int [] num = {1,2,3,4,5,99,-2};
		Outer ot = new Outer(num);
		ot.analyze();
	}
}
