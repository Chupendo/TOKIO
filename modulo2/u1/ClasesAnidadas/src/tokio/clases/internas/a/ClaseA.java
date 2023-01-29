package tokio.clases.internas.a;

public class ClaseA {

	//Miembro estatico
    static int externo_x = 10;
    //Miembro de instancia
    int externo_y = 20;
    //Miembro privado
    private static int externo_privado = 30; 

    //Clase anidada no estatica
    public class ClaseAnStatic{
        void mostrar(){
            //Puede acceder al miembro estatico de la clase externa
            System.out.println("externo_x: "+externo_x);

            /*Puede acceder a mostrar un miembro estatico privado de la clase externa */
            System.out.println("externo_privado: "+externo_privado);
            
            /* Acceso no miembro statico */
            System.out.println ("externo_y ="+externo_y);
        }
    }
}
