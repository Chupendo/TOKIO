package exercicies;

public class Exercicie16 {

	public static void main(String[] args) {

		int n = 3;
		MyIntNum myNum = new MyIntNum(16);
		UtilsInt testHash = myNum::hasCommonFactor;

		System.out.println(myNum.getV() + " and " + n + " has common factor? " + testHash.test(n));

	}

	public static class MyIntNum {
		private int v;

		public MyIntNum(int x) {
			v = x;
		}

		public int getV() {
			return this.v;
		}

		boolean hasCommonFactor(int n) {
			return (findGCD(this.v,n)!=1)?true:false;
		}
		
		static int findGCD(int a, int b) {
			if (b == 0)
				return a;
			return findGCD(b, a % b);
		}

	}

	public interface UtilsInt {
		boolean test(int n);
	}
}
