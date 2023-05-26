package exercicies;

public class Exercicie7 {
	public static void main(String[] args) {
		NumericFunc<Integer> fac = (num) -> {
			int i = num.intValue()-1;
			int resu = num.intValue();
			while(i>1) {
				resu *= i;
				i--;
			}
			return resu;
		};
		
		System.out.println("7! = "+fac.func(7));
		System.out.println("3! = "+fac.func(3));
	}

	public interface NumericFunc<T extends Number>{
		T func(T n);
	}
}
