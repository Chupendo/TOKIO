package supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class example2 {

	public static void main(String[] args) {
	
		List<Integer> arInt = IntStream.rangeClosed(0, 20)
				.limit(10)
				.mapToObj(Integer::valueOf)
				.peek(System.out::println)
				.collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
				//.collect(Collectors.toList());
		
		Double avg = arInt.stream()
				.mapToInt(Integer::valueOf)
				.average()
				.orElse(0);
		System.out.println("average(): "+avg);
	}
}
