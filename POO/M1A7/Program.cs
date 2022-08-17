using System;

namespace DotnetBot{
    public static class Program{
        public static void Main(string [] args){ 
            String message = "Hola Mundo: ";
            Console.WriteLine("Introduce un texto: ");
            String texto;
            texto = Console.ReadLine();
            Console.WriteLine(message+" "+texto);
        }
    }
}