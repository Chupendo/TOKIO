package com.tokio.exercicies;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileWithScanner {

	public static final boolean OVERWRITTER = false;
	public static void main(String[] args) {
		File f = new File("file5.txt");
		if(f.exists()) {
			try(final Scanner sc = new Scanner(f)){
				System.out.println(sc.nextLine());
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				if(f.createNewFile()) {
					try(final PrintWriter pw = new PrintWriter(new FileWriter(f),OVERWRITTER)){
						pw.format("creo fichero %s",12313);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
