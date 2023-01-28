package algorithms.sor;

import java.util.stream.Stream;

import algorithms.sort.Sotable;

public class UtilOrdenar implements  Sotable {
	
	@Override
	public <T extends Comparable> void sort(T[] values) {
		Stream.of(values).sorted().forEach(System.out::println);
	}
}
