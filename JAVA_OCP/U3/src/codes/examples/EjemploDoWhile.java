package codes.examples;

public class EjemploDoWhile {

	public static void main(String[] args) {
        // Declaraci�n de variables
        int res = 10;
        int num2 = 1;
  
        
        do {	
            // Inicio del bucle do � while
            res = res - num2;
            num2++;
        }while(res>1);
        System.out.println(res);
        
        /*La condici�n se comprueba al final, por lo que con el bucle do while, nos aseguramos de que las instrucciones se ejecuten al menos una vez.  */ 
    }
}