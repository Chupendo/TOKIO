package astart.mymodappdemo;

import java.util.ServiceLoader;

import userfuncs.binaryfuncs.services.BinaryFuncProvider;

public class MyModAppDemo {

	public static ServiceLoader<BinaryFuncProvider> servi;

	public static void main(String[] args) {
		servi = ServiceLoader.load(BinaryFuncProvider.class);

		//servi.forEach(System.out::println);
		for (BinaryFuncProvider bfp : servi) {
			System.out.println(bfp.get());
			System.out.print(bfp.get().getName()+": ");
			System.out.println(bfp.get().func(2, 3));
		}
	}
}
