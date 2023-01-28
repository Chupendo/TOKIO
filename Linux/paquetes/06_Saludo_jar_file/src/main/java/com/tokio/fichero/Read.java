package com.tokio.fichero;

import java.io.File;
import java.io.FileReader;


import java.io.BufferedReader;

public class Read{
	protected String  text;
	private static final String file = "03_Slaudo_fichero/bin/resources/file.txt";


	public Read(){
		this.text = "";
		read();
	}

	public void addText(String txt){
		this.text += txt;
	}
	public String getText(){
		return text;
	}

	private void read(){
		File f = new File(file);
		FileReader fr = null;
		BufferedReader br = null;
		try{
			System.out.println("abosulute path= "+f.getAbsolutePath());
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			String aux;
			while( (aux=br.readLine())!=null){
				this.text += aux;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(fr!=null){
					fr.close();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

	}
}
