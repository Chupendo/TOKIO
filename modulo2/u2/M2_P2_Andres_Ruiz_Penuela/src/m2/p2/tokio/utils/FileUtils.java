package m2.p2.tokio.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

	/**
	 * Metodo de lecutra de ficheros Flujo de E/S de caracteres
	 * 
	 * @param pathAbsFile Ruta absoluta del fichero
	 * @return Flujo de caracteres leido del fichero o null
	 */
	public static List<String> read(String pathAbsFile) {
		List<String> info = new ArrayList<>();

		// FileReader fr = new FileReader(pathAbsFile, StandardCharsets.ISO_8859_1);
		try (final FileReader fr = new FileReader(pathAbsFile); final BufferedReader br = new BufferedReader(fr)) {
			String line;
			while ((line = br.readLine()) != null) {
				// Set enconding
				info.add(new String(line.getBytes(), StandardCharsets.ISO_8859_1));
			}
			return info;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Metodo que remplaza los espacios por '-'
	 * 
	 * @param info
	 * 	Lista de flujo de caractres a modificar
	 * @return Flujo de caractres sin espaicos
	 */
	public static List<String> deleteSpace(List<String> info) {
		return info.stream().map(line -> line.replace(' ', '-')).collect(Collectors.toList());
	}

	/**
	 * Metodo copia el copia una una lista de caractres en un fichero
	 * 
	 * @param info
	 * 		Lista de caracteres
	 * @param pathAbsFile
	 * 		Ruta absoluta del fichero donde se aloja el contenido
	 * @throws IOException,  NullPointerException
	 */
	public static void copy(List<String> info, String pathAbsFile) {

		try (FileWriter fw = new FileWriter(pathAbsFile, false);
				PrintWriter pw = new PrintWriter(fw)
				) {
			for (String line : info) {
				pw.println(new String(line.getBytes(StandardCharsets.ISO_8859_1)));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
