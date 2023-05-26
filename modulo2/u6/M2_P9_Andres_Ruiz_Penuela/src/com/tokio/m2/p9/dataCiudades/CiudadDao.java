package com.tokio.m2.p9.dataCiudades;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;

import tokio.school.m2.p9.dto.Ciudad;

public class CiudadDao {
	/**
	 * Funcion utilizada para generar una lista de ciduades
	 * 
	 * @param size
	 * @return
	 */
	public static List<Ciudad> createLCiudades(int size) {
		// Funciones para generar numeros aletorios
		BiFunction<Long, Long, Long> generateLong = (leftLimit, rightLimit) -> ThreadLocalRandom.current()
				.nextLong(leftLimit, rightLimit);
		BiFunction<Integer, Integer, Integer> generateInt = (leftLimit, rightLimit) -> ThreadLocalRandom.current()
				.nextInt(leftLimit, rightLimit);
		// Rango para generar un numero de poblacion
		Long min = 500L, max = 99999L;

		// Cicudades y poblaciones
		String[] pMalaga = { "Benalmádena", "Marbella", "Fuengirola", "Málaga" };
		String[] pJaen = { "Álcala la Real", "Martos", "Andújar", "Úbeda", "Jaén" };
		String[] pAlmeria = { "Almería", "El Ejido", "Roquetas de Mar", "Adra" };
		String[] pMadrid = { "Madrid", "Ciudad Real", "Cuenca", "Guadalajara", "Toledo" };
		String[] pValencia = { "Valencia", "Torrente", "Gandía", "Paterna", "Quart de Polet", "Manises" };
		String[] pMurcia = { "Murcia", "Cartajena", "Lorca", "Molina de Segura", "La Unión", "Alcantarilla" };

		// Mapa de <ciduad,pobacliones>
		Map<String, String[]> mCiudades = Map.of("Malaga", pMalaga, "Jaen", pJaen, "Almeria", pAlmeria, "Madrid",
				pMadrid, "Valencia", pValencia, "Murica", pMurcia);

		// Calculamos el maximo tamaño del array permitdo
		Long n = mCiudades.entrySet().stream().map(Map.Entry::getValue).count();
		int m = mCiudades.entrySet().stream().map(Map.Entry::getValue).mapToInt(v -> v.length).sum();
		Long maxSize = (n * m) < size ? (n * m) : size;

		// Generamos la lista de ciudades
		int index = 0;
		List<Ciudad> lCiudades = new ArrayList<>();
		Object[] keys = mCiudades.keySet().toArray();

		for (int i = 0; i < maxSize; i++) {
			// Obtenemos una poblacion aletaria (key del map)
			index = genNumb(generateInt, 0, keys.length);
			String ciudad = (String) keys[index];

			// Obtenemos una provincia alegarioa de la ciudad (value del map)
			String[] provincias = mCiudades.get(ciudad);
			index = genNumb(generateInt, 0, provincias.length);
			String provincia = provincias[index];

			// Obtenemos un numero de poblacion aleatiro
			Long generatedInteger = genNumb(generateLong, min, max);

			Ciudad c = new Ciudad(ciudad, provincia, generatedInteger);
			// Evita dubplicados
			if (!lCiudades.contains(c)) {
				lCiudades.add(c);
			}
		}

		// Devuelve lista de ciduades generada
		return lCiudades;
	}

	private static <T extends Number> T genNumb(BiFunction<T, T, T> biFun, T min, T max) {
		return biFun.apply(min, max);
	}
}
