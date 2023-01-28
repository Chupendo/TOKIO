package com.tokio.funcs;

public class Operations{
	
	public static int sumInt(int... data){
		int result = 0;
		if(data==null)
			return 0;

		for(int i=0;i<data.length;i++){
			result += data[i];
		}
		return result;
	}
}