package exercicies.heredity.u6.ejer2.service;

import java.util.Scanner;

import exercicies.heredity.u6.ejer2.CiudadDto;
import exercicies.heredity.u6.ejer2.JugadroDto;
import exercicies.heredity.u6.ejer2.PersonajeDto;

public class CivilitationService {
	
	/**
	 * Metodo que guarda el tiempo en segudos
	 * del Jugador
	 * @param jg1
	 * 	JugadorDto datos del jugador
	 */
	public static void saveTime(JugadroDto jg1) {
		jg1.setTime(System.currentTimeMillis()/1000);
	}
	
	public static void createCity(JugadroDto jg1) {
		/*String nameCity = Input.getString("Inserte el nombre de la ciudad: ");
		String nameJugadro = Input.getString("Inserte el nombre del jugador: ");
		String apellidos =  Input.getString("Inserte los apellidos del jugador: ");
		
		String nombrePersonaje = Input.getString("Inserte el nombre del personaje: ");
		String epoca = Input.getString("Inserte el epoca: ");*/
		String nombreCidaud = Input.getString("Inserte el nombre de la ciudad: ");		
		CiudadDto ciudad = new CiudadDto(nombreCidaud);
		
		jg1.getPersonaje().setCiudad(ciudad);
	}
	
	public static void uppNevel(JugadroDto jg1) {
		jg1.getPersonaje().setNivel((short)(jg1.getPersonaje().getNivel()+1));
		switch((jg1.getPersonaje().getNivel())) {
			case 10:
				jg1.getPersonaje().getCiudad().setTipo((byte)1);
				break;
			case 20:
				jg1.getPersonaje().getCiudad().setTipo((byte)2);
				break;			
		}
	}
	
	public void esperar() throws InterruptedException {
		wait(500L);
	}
}
