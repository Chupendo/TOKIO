package com.tokio.colagen;

public class QueueGenImp {

	public static void main(String[] args) {
		String [] m1 = new String[5];
		QueueGen<String> strQ = new QueueGen<>(m1);
		
		try {
			strQ.put("a");
			strQ.put("b");
			strQ.put("c");
			strQ.put("d");
			strQ.put("e");
			strQ.put("f");
			strQ.put("g");
		} catch (QueueFullException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(strQ.get());
			System.out.println(strQ.get());
			System.out.println(strQ.get());
			System.out.println(strQ.get());
			System.out.println(strQ.get());
			System.out.println(strQ.get());
		} catch (QueueEmpatyException e) {
			e.printStackTrace();
		}
	}
}
