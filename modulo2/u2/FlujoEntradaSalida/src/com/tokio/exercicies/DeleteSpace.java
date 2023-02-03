package com.tokio.exercicies;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Remplaza los espacios por "-"
 * FLujo E/S de bytes
 * 
 * @author andre
 *
 */
public class DeleteSpace {

	public static void main(String[] args) {
		FileInputStream fin = null;
		FileOutputStream fout = null;
		try {
			fin = new FileInputStream("file.txt");
			fout = new FileOutputStream("file2.txt",true);
			int i;
			do {
				i = fin.read();
				if(i!=-1) {
					if(((char)i)==' ') {
						fout.write('-');
					}else {
						fout.write(i);
					}
					
				}else {
					fout.write('\n');
				}
			}while(i!=-1);
		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fin.close();
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
