package appstart.mymodappdemo;

import appfuncs2.simplefuncs.SimpeMathfunc;
import appsurpport.supportfuncs.SupportsFuncs;

public class MyModAppDemo{
	
	public static void main(String[] args) {
		if(SupportsFuncs.isFactor(2, 10))
			System.out.println("2 is Factor of 10");
		
		System.out.println("Smallest factor common to both 35 and 105 is "+
				SimpeMathfunc.lcf(35, 105));
		
		System.out.println("Largest factor common to both 35 and 105 is "+
				SimpeMathfunc.gcf(35, 105));
	}
}