package mapas;

import java.util.Map;

public class Mapas {

	public static void main(String[] args) {
		// Declarión de Mapas
		Map<String,String> mapaUsuarios;
		Map<String,Television> mapaTelevision;
		Map<int,int> mapaTipoPRimitivo //ERROR;

		//Instanciación
		Map<String,String> mapaUsuarios = new HashMap<>();
		Map<String,Television> mapaTelevision = new HashMap<>();

		//Otra forma de instanciación
		Map<String,String> mapaUsuarios = new TreeMap<>();
		Map<String,Television> mapaTelevision = new TreeMap<>();
		
		// Guarda usuarios/as con clave DNI y con valor objeto de tipo Television
		mapaUsuarios.put("00000001A", "JORGE RIVERA LOPEZ");
		mapaUsuarios.put("00000002B", "LUCAS GARCIA FERNANDEZ");
		mapaUsuarios.put("00000003C", "LAURA MARTIN GARCIA");

		// Guarda televisiones con clave Numero de pedido y con valor objeto de tipo Television
		mapaTelevision.put("0001", new Television("LG", 60 ));
		mapaTelevision.put("0002", new Television("SAMSUNG", 55 ));
		
		System.out.println(mapaUsuarios.get("00000001A"));
		System.out.println(mapaUsuarios.get("00000003C"));
		System.out.println(mapaTelevision.get("0001"));
	}

}
