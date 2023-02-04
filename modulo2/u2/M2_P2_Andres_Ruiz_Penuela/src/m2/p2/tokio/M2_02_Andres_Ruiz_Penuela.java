package m2.p2.tokio;

import java.util.ArrayList;
import java.util.List;

import m2.p2.tokio.utils.FileUtils;

public class M2_02_Andres_Ruiz_Penuela {
	private static final String pathAbsFileInt = "M2_T02_Origen.txt";
	private static final String pathAbsFileOut = "M2_T02_Destino.txt";
	
	public static void main(String[] args) {
		
		List<String> info = new ArrayList<>();

		try {
			//1º Lee el fichiero
			info = FileUtils.read(pathAbsFileInt);
			
			//2º Remplaza espacios
			info = FileUtils.deleteSpace(info);
			
			//3º Vuelva el contenido
			FileUtils.copy(info, pathAbsFileOut);
			
			//4º Muesta la info volcada
			if(info!=null)
				info.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
