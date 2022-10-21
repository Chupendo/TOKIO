package examples.comporator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main extends AlgoritmosOrdenacion {
	
	public static void main(String[] args) {
		String str1 = "A";
		String str2 = "B";
		
		System.out.println("[compareStringAlf] "+str1+">"+str2+"? "+compareStringAlf(str1, str2));
		System.out.println("[compareStringAlfInv]"+str1+">"+str2+"? "+compareStringAlfInv(str1, str2));
		
		String [] data = {"apple", "banana","orange","melon","wiki","watermelon"};
		List<String> lStr = new ArrayList<>(Arrays.asList(data));
		
		System.out.println("list: "+lStr);
		Comparator<String> comp1 = (obj1,obj2) -> compareStringAlfInv(obj1, obj2);
		Comparator<String> comp2 = (obj1,obj2) -> compareStringAlf(obj1, obj2);
		lStr.sort(comp1);
		System.out.println("list ord inv: "+lStr);
		lStr.sort(comp2);
		System.out.println("list ord: "+lStr);
	}

}
