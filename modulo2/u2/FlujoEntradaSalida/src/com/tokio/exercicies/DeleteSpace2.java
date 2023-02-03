package com.tokio.exercicies;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Remplaza los espacios por "-"
 * FLujo E/S de caracteres
 * 
 * @author andre
 *
 */
public class DeleteSpace2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		try(FileReader fr = new FileReader("file.txt");
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter("file3.txt", false)){
			String data = null;
			do {
				data = br.readLine();
				if(data!=null) {
					data = data.replace(' ', '-');
					fw.write(data.toCharArray());
					fw.write('\n');
				}
			}while(data!=null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
