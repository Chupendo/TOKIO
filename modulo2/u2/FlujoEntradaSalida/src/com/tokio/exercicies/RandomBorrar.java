package com.tokio.exercicies;

import java.io.RandomAccessFile;

public class RandomBorrar {
	public static void main(String[] args) {
			try(RandomAccessFile accessFile = new RandomAccessFile("file.txt","rw")){
				accessFile.writeUTF("Escribo ");
				accessFile.seek(0);
				System.out.println( accessFile.readLine());
				accessFile.seek(8);
				System.out.println( accessFile.readLine());
				
			}catch (Exception e) {
				// TODO: handle exception
			}
	}
}
