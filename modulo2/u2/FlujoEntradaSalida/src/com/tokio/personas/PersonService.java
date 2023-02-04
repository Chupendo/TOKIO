package com.tokio.personas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


import org.apache.commons.lang3.SerializationUtils;

public class PersonService {

	private static final String PATH_ABS_FILE = "person.csv";
	private static final String PATH_ABS_FILE_2 = "person.dat";
	private static final String PATH_ABS_FILE_3 = "person.obj";
	private static final String PATH_ABS_FILE_NIO = "nio2.txt";
	public static final boolean OVERWRITTER = false;

	public static Person saved(Person p) throws IOException {

		// Buffer de bytes + Flujo E/S de bytes
		try (FileOutputStream fout = new FileOutputStream(PATH_ABS_FILE, OVERWRITTER);
				DataOutputStream dos = new DataOutputStream(fout)) {
			// Data person
			dos.writeBytes(p.getNombre());
			dos.writeBytes(",");
			dos.writeBytes(Integer.toString(p.getEdad()));
			dos.writeBytes(",");
			dos.writeBytes(p.getNif());
			dos.writeBytes(",");
			dos.writeBytes(p.getNacimiento().toString());
			dos.writeBytes("\n");

		} catch (IOException e) {
			//
			throw new IOException(e.getCause());
		}

		return p;
	}

	public static Person saved2(Person p) throws IOException {

		// Buffer de bytes + Flujo E/S de bytes
		try (FileOutputStream fout = new FileOutputStream(PATH_ABS_FILE_2, OVERWRITTER);
				DataOutputStream dos = new DataOutputStream(fout)) {
			// Data person
			byte[] info = SerializationUtils.serialize(p);
			dos.write(info);
			dos.writeUTF("\n");

		} catch (IOException e) {
			throw new IOException(e.getCause());
		}

		return p;
	}

	public static Person saved3(Person p) throws IOException {

		// Buffer de bytes + Flujo E/S de bytes
		try (FileOutputStream fout = new FileOutputStream(PATH_ABS_FILE_3, OVERWRITTER);
				ObjectOutputStream dos = new ObjectOutputStream(fout)) {
			// Data person
			dos.writeObject(p);
			dos.writeUTF("\n");

		} catch (IOException e) {
			throw new IOException(e.getCause());
		}

		return p;
	}

	public static void saved4(List<String> lData) throws IOException {

		// Buffer de bytes + Flujo E/S de caracter with NIO2
		try {
			// Crea o Sobrescribe
			Files.write(Paths.get(PATH_ABS_FILE_NIO), lData);
			// Agrega al final
			// Files.write(Paths.get(PATH_ABS_FILE_NIO), lData, StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new IOException(e.getCause());
		}
	}

	public static Person read() throws IOException {
		Person p = new Person();
		try {
			// Flujo E/S caracteres + NIO2
			List<String> info = Files.readAllLines(Paths.get(PATH_ABS_FILE));
			for (String inf : info) {
				System.out.println(inf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	public static void read2() throws IOException {

		Person p = new Person();
		File f = null;
		DataInputStream dis = null;
		try {
			f = new File(PATH_ABS_FILE);

			dis = new DataInputStream(new FileInputStream(f));

			byte[] aux = new byte[(int) f.length()];
			aux = dis.readAllBytes();
			
			for(int i=0;i<aux.length;i++) {
				System.out.print((char)aux[i]);
			}
			

		} catch (Exception e) {
			// TODO: handle exceptionç
			e.printStackTrace();
		} finally {
			// dis.close();
		}
	}
}
