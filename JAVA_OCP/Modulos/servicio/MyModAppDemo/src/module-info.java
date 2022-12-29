/**
 * 
 */
/**
 * @author andre
 *
 */
module MyModAppDemo {
	requires userfuncsimp;
	requires userfuncs; // sedebe poner si no se usa requires transitive usersfuncs en userfuncsimp
	uses userfuncs.binaryfuncs.services.BinaryFuncProvider;
}