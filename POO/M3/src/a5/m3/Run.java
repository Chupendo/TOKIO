package a5.m3;

import a5.m3.parte2.Portatil;

public class Run {

	public static void main(String[] args) {
		//Declaracion & Inicialización
		Sobremesa pc1 = new Sobremesa("msi",8,1050,875.5,250);
		Portatil pc2 = new Portatil("HP", 16, 1050, 899.99, 1500.0);
		
		System.out.println("------------\n\tSobremesa\n------------");
		//Acceso a los attr de PC1 (clase hija en el mismo paquete que la clase padre)
		System.out.println("Modelo= "+pc1.modelo);					//attr father publico
		System.out.println("Ram= "+pc1.ram);						//attr father protected 
		System.out.println("Grafica= "+pc1.grafica);				//attr father pacakge
		System.out.println("Precio= "+pc1.getPrice());				//attr father private
		System.out.println("Alimentacion= "+pc1.getAlimentacion()); //attr son private
		//metodo publico de clase que muestra todos los atributos que tiene acceso
		System.out.println(pc1.toString());
		
		System.out.println("------------\n\tPortatil\n------------");
		//Acceso a los attr de PC2 (clase hija en otro paquete que la clase padre)
		System.out.println("Modelo= "+pc2.modelo);					//attr father publico
		System.out.println("Ram= "+pc2.ram);						//attr father protected (!=package but Portatil es derivada de PC)
		//System.out.println("Grafica= "+pc2.grafica);				//attr father pacakge	(!=package)
		System.out.println("Precio= "+pc2.getPrice());				//attr father private
		System.out.println("Alimentacion= "+pc2.getBateria()); 		//attr son private
		//metodo publico de clase que muestra todos los atributos que tiene acceso
		System.out.println(pc2.toString());
	}

}
