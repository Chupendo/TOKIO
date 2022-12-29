module userfuncsimp {
	//requires transitive userfuncs;
	requires userfuncs;
	
	provides userfuncs.binaryfuncs.services.BinaryFuncProvider with 
	userfuncsimp.binaryfuncs.AbsPlusProvider,
	userfuncsimp.binaryfuncs.MinusProvider;
}