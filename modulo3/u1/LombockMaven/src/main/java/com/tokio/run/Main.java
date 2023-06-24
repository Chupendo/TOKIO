package com.tokio.run;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Person p1 = new Person("id", "arp", 18, new Date());
		System.out.println(p1.toString());
	}
}
