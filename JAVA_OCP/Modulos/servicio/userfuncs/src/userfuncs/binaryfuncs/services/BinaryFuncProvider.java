package userfuncs.binaryfuncs.services;

// Provee una acción, es decir, devuelve
// una instancia de un servio, en este caso
// de BinaryFunc.
public interface BinaryFuncProvider {

	// Devuleve una instancia de {@link BinFuncProvider userfuncs.binaryfuncs#BinaryFunc}
	public BinaryFunc get();
}