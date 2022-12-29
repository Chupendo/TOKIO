package userfuncsimp.binaryfuncs;

import userfuncs.binaryfuncs.services.BinaryFuncProvider;
import userfuncs.binaryfuncs.services.BinaryFunc;

public class MinusProvider implements BinaryFuncProvider {
	@Override
	public BinaryFunc get() {
		// Proporciona una instancia de AbsPlus
		return new AbsMinus();
	}
}
