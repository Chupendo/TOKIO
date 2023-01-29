package com.tokio.vehiculo;

import java.util.Scanner;

import com.tokio.vehiculo.Coche.Rueda;
import com.tokio.vehiculo.Coche.Rueda.TIPO;

public class Main {

	public static void main(String[] args) {
		Coche coche = new Coche();

		//Setea los valores de una instancia de tipo Coche parada por referecia
		create(coche);
		
		//Muestra los valores seteados
		System.out.println(coche.toString());

	}

	public static void create(Coche coche) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Inserte matricula: ");
		coche.setMatricula(sc.nextLine());

		System.out.print("Inserte marca: ");
		coche.setMarca(sc.nextLine());
		
		System.out.print("Inserte modelo: ");
		coche.setModelo(sc.nextLine());

		coche.setPotencia(catchFloat("Inserte potencia: ", sc));

		coche.setVelocidad(catchFloat("Inserte velocidad: ", sc));

		
		System.out.print("Inserte material del chasis: ");
		sc.nextLine(); //Limpiar Buffer
		coche.setMaterialChasis(sc.nextLine());
		
		
		coche.setPesoChasis(catchFloat("Inserte peso del chasis: ", sc));

		Rueda ruedas[] = new Rueda[4];
		for (int i = 0; i < 4; i++) {
			Rueda r = new Rueda();
			
			System.out.print("Inserte marca de la rueda: ");
			sc.nextLine(); //Limpiar Buffer
			r.setMarca(sc.nextLine());
			
			r.setMedida(catchFloat("Inserte medidad de la rueda: ", sc));
			sc.nextLine(); //Limpiar Buffer
			
			System.out.print("Inserte modelo de la rueda: ");
			r.setModelo(sc.nextLine());
			
			int op = 0;
			do {
			
				System.out.print("Indique tipo de rueda:\n\t" + "1." + Rueda.TIPO.Lluvia.toString() + "\n\t" + "2."
						+ Rueda.TIPO.Seco.toString() + "\n\t" + "Valor: ");
				op = catchInt(sc);

				switch (op) {
				case 1:
					r.setTipo(TIPO.Lluvia);
					break;
				case 2:
					r.setTipo(TIPO.Seco);
					break;
				default:
					System.err.println("Intentelo de nuevo.");
					op=0;
				}
			} while (op==0);
			
			ruedas[i]=r;
		}
		coche.setRueda(ruedas);
	}

	public static float catchFloat(String msg, Scanner sc) {
		while (true) {
			try {
				System.out.print(msg);
				return sc.nextFloat();
			} catch (Exception e) {
				sc.next();
				System.err.println("Error " + e.getCause());
				continue;
			}
		}
	}

	public static int catchInt(Scanner sc) {
		try {
			return sc.nextInt();
		} catch (Exception e) {
			return 0;
		}
	}
}
