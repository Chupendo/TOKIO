package com.tokio.fileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReaderSample {

	public static void main(String[] args) {
		try(FileReader fr = new FileReader("file.txt")){
			PrintWriter pw = new PrintWriter(System.out,true);
			int i;
			do {
				i = fr.read();
				if(i!=-1)
					pw.format("%s",(char)i);
				
			}while(i!=-1);
			
			pw.print(fr.read());
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
