package tokio.school.m2.p8.dao;

import java.util.function.Function;

import tokio.school.m2.p8.dto.Dog;


public class DogDao {

	public Function<Dog, String> getName = d->d.getName();
	public Function<String, Character> getInitial = data->data.charAt(0);
	
} 
