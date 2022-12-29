package userfuncsimp.binaryfuncs;

import userfuncs.binaryfuncs.services.BinaryFunc;

public class AbsMinus implements BinaryFunc {

	@Override
	public String getName() {
		return "absplus";
	}

	@Override
	public int func(int a, int b) {
		// Suma de valor absoluto
		return Math.abs(a)+Math.abs(b);
	}
}
