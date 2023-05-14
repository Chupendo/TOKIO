package com.tokio.ejerc.stack;

import java.util.EmptyStackException;

public class MyStactUse {

	public static void main(String[] args) {
		MyStack<Integer> mSt = new MyStack<>(3);
		
		 mSt.forEach(System.out::println);
		 int count = 0;
		 do {
			
			 try {
				 
				 System.out.println(mSt.pop());
				Thread.sleep(1000);
			} catch (InterruptedException | EmptyStackException | StackOverflowError e) {
				e.printStackTrace();
				mSt.push(11);
				mSt.push(12);
				mSt.push(13);
			}
			 
			 if(count<10) {
				 System.out.println("Continue");
			 }else {
				 System.out.println("Exite");
			 }
			 count++;
		 }while(count < 10);
	}
}
