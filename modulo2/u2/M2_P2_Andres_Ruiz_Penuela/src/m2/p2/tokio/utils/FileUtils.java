package m2.p2.tokio.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase para el procesamiento de ficheros
 * 
 * @author Andres Ruiz Peñuela
 *
 */
public class FileUtils {

	/**
	 * Metodo de lecutra de ficheros Flujo de E/S de caracteres
	 * 
	 * @param pathAbsFile Ruta absoluta del fichero
	 * @return Flujo de caracteres leido del fichero o null
	 */
	public static List<String> read(String pathAbsFile) {
		if (pathAbsFile == null)
			return null;

		File f = null;
		InputStream fis = null;
		BufferedReader br = null;
		String aux = "";
		List<String> info = new ArrayList<>();
		InputStreamReader isr = null;
		try {
			// Open el fichero
			f = new File(pathAbsFile);
			if (!f.exists())
				return null;
			;

			// Flujo E/S de caracteres
			fis = new FileInputStream(f);
			isr = new InputStreamReader(fis, StandardCharsets.ISO_8859_1);

			// Buffer de entrada
			br = new BufferedReader(isr);

			// Lee el documento liena a liena
			while ((aux = br.readLine()) != null) {
				info.add(aux);
			}

			// devuelve el resultado
			return info;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// cerramos los ficheros
			try {
				if (fis != null) {
					fis.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//erro al leer el fichero
		return null;
	}

	/**
	 * Metodo que remplaza los espacios por '-'
	 * 
	 * @param info
	 * 	Lista de flujo de caractres a modificar
	 * @return Flujo de caractres sin espaicos
	 */
	public static List<String> deleteSpace(List<String> info) {
		if (info == null)
			return null;

		return info.stream().map((d) -> d.replace(' ', '-')).collect(Collectors.toList());
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
	public static void copy(List<String> info, String pathAbsFile) throws IOException {
		if(info==null||pathAbsFile==null)
				throw new NullPointerException("No se puede crear el fichero");
		
		OutputStream os = null;
		OutputStreamWriter osw = null;
		try {
			os = new FileOutputStream(pathAbsFile, false);
			osw = new OutputStreamWriter(os, StandardCharsets.ISO_8859_1);

			for (String i : info) {
				osw.write(i + "\n");
			}

		} catch (IOException e) {
			throw e;
		} finally {
			try {
				osw.close();
				os.close();

			} catch (IOException e) {
				throw e;
			}

		}
	}
}
