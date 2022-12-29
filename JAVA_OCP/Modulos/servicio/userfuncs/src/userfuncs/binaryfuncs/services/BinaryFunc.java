package userfuncs.binaryfuncs.services;

// Define una acción a través de un método que 
// toma dos argumentos "int" y devuelve un resutlado
// int. 
// De esta manera se puede implementar cualquier
// operación binaria con dos ints y un valor
// de retorno int
public interface BinaryFunc {

		//Obtiene el nombre de la función
		public String getName();
		
		//Esta es la función que se ejecuta. La
		//proporcionara dos implemetnaicones especificas
		public int func(int a, int b);
}
