package userfuncsimp.binaryfuncs;

import userfuncs.binaryfuncs.services.BinaryFunc;

public class AbsPlus implements BinaryFunc {

	@Override
	public String getName() {
		return "absMinus";
	}

	@Override
	public int func(int a, int b) {
		// Suma de valor absoluto
		return Math.abs(a)-Math.abs(b);
	}
}
