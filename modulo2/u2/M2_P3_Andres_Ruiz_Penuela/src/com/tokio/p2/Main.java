package com.tokio.p2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) {
		int[] data = {1,1,1,2,2,2,2,2,2};
		String nameFile = "numeri.log";
		
		//Writer File
		FileOutputStream fos = null; //Flujo E/S bytes
		try {
			fos = new FileOutputStream(nameFile, false);
			for(int d : data) {
				fos.write(d);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//Read-Writer File
		RandomAccessFile raf = null; //Flujo E/S bytes
		try {
			
			raf = new RandomAccessFile(nameFile, "rw");
			int i,j=0;
			
			raf.seek(j);
			while((i=raf.read())!=-1){
				if(i==2){
					raf.seek(j);//set cursor
					raf.write(3);
				}
				j++;
					
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(raf!=null) {
				try {
					raf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//Writer file
		FileInputStream fis = null; //Flujo E/S bytes
		try {
			
			fis = new FileInputStream(nameFile);
			
			int i;
			while((i=fis.read())!=-1){
				//Contend
				System.out.print(i);
					
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	//
	
	
}
