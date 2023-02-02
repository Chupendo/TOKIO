package com.tokio.stream_bytes;
import java.io.IOException;

public class SampleStreamBytes {

	public static void main(String[] args) throws IOException {
		byte datos[] = new byte[5];
        System.out.println("Ingrese algunos caracteres.");
        
        // Lee un array de bytes desde el teclado
        System.in.read(datos);
        System.out.print("Usted ingresó: ");
        
        for(int i = 0; i<datos.length; i++) {
            System.out.print((char)datos[i]);
        }
        System.out.println(".");
		
	}
}
