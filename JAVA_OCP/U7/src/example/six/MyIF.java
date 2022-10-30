package example.six;

public interface MyIF{

	// Declaración de un metodo de interfal "normal"
	// No define una implemetnación predeterminada.
	int getUserID();
	
	// Un método predeterminado. 
	// Proporicona una implementación de propostio general
	default int getAdminID() {
		return 1;
	}
}
