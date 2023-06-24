package com.core.run;

import java.util.stream.Stream;

import org.apache.commons.math3.stat.StatUtils;

public class App {

	public static void main(String[] args) {
		System.out.println("Hello World");
		double[] numeros = { 7, 8, 3, 5,6, 7, 1, 34};
		// Media
		System.out.println(StatUtils.mean(numeros));
		//
		System.out.println("Argumentos");
		Stream.of(args).forEach(System.out::println);
	}
}
