package exercicies.heredity.u6.ejer1.service;

import java.util.Scanner;

import exercicies.heredity.u6.ejer1.dto.Vehiculo;

public class VehiculoService {
	public static final char lColor[] = { 'r', 'a', 'n', 'b' };

	public static final char printVehiculo() {
		Scanner sc = new Scanner(System.in);
		short option;
		do {
			System.out.print("Inserte el color nuevo: " + "\n\t1. Rojo." + "\n\t2. Azul." + "\n\t3. Negro."
					+ "\n\t4. Blanco." + "\nIndique el numero del color nuevo (0 para salir): ");

			try {
				option = sc.nextShort();

			} catch (Exception ie) {
				System.err.println(ie);
				option = -1;
			}

			if (option >= 1 && option <= lColor.length)
				break;
		} while (true);

		return lColor[option - 1];
	}

	public static Vehiculo newVehiculo() {

		Vehiculo vh = new Vehiculo();
		vh.setNumBastidor(getInt("Inserte el numero de bastidor: "));
		vh.setMatricula(getString("Inserte la matricula: "));
		vh.setModelo(getString("Inserte el modelo del vehiculo: "));
		vh.setColor(printVehiculo());
		vh.setKilometraje(getFloat("Inserte el kilometraje: "));
		vh.setReparado(false);
		return vh;
	}


	public static String getString(String msg) {
		Scanner sc = new Scanner(System.in);
		boolean err = false;
		String resultado;
		do {
			System.out.print(msg);
			try {
				resultado = sc.nextLine();
				err=true;
			} catch (Exception e) {
				System.err.println(e);
				sc.next();
				resultado=null;
				err=false;
			}
		} while (!err);
		return resultado;
	}
	
	public static int getInt(String msg) {
		Scanner sc = new Scanner(System.in);
		boolean err = false;
		int resultado;
		do {
			System.out.print(msg);
			try {
				resultado = sc.nextInt();
				if(resultado>=0)
					err=true;
			} catch (Exception e) {
				System.err.println(e);
				sc.next();
				resultado=-1;
				err=false;
			}
		} while (!err);
		return resultado;
	}
	
	public static short getShort(String msg) {
		Scanner sc = new Scanner(System.in);
		boolean err = false;
		short resultado;
		do {
			System.out.print(msg);
			try {
				resultado = sc.nextShort();
				if(resultado>=0)
					err=true;
			} catch (Exception e) {
				System.err.println(e);
				sc.next();
				resultado=-1;
				err=false;
			}
		} while (!err);
		return resultado;
	}
	
	public static float getFloat(String msg) {
		Scanner sc = new Scanner(System.in);
		boolean err = false;
		float resultado;
		do {
			System.out.print(msg);
			try {
				resultado = sc.nextFloat();
				if(resultado>=0)
					err=true;
			} catch (Exception e) {
				System.err.println(e);
				sc.next();
				resultado=-1;
				err=false;
			}
		} while (!err);
		return resultado;
	}
	
	public static boolean getBoolean(String msg) {
		Scanner sc = new Scanner(System.in);
		boolean err = false;
		short resultado;
		do {
			System.out.print(msg);
			try {
				resultado = sc.nextShort();
				if(resultado==1||resultado==0)
					break;
			} catch (Exception e) {
				System.err.println(e);
				sc.next();
				resultado=-1;
				err=false;
			}
		} while (!err);
		
		return resultado==1?true:false;
	}
}
