package com.tokio.Hello;

//import org.apache.commons.lang3.StringUtils;

public class Hello {

	public static void main(String[] args) {
		
		//Con el import org.apache.commons.lang3.StringUtils
		//Descomentar import
		//System.out.println(StringUtils.capitalize("helllo world!"));
		
		//Sin el import org.apache.commons.lang3.StringUtils
		//Comentar import y lina 12
		System.out.println(org.apache.commons.lang3.StringUtils.capitalize("helllo world!"));
	}
}