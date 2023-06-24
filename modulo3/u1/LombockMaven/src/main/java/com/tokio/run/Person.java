package com.tokio.run;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


@Data
@AllArgsConstructor
public class Person {
	@NonNull protected String identification;
	@NonNull protected String name;
	protected int age;
	protected Date birthday;
}
