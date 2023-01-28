module OrdString {
	requires Ordenar;
	exports algorithms.sor;
	
	provides algorithms.sort.Sotable with algorithms.sor.UtilOrdenar;
	
}