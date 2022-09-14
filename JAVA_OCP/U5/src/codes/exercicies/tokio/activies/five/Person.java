package codes.exercicies.tokio.activies.five;

import codes.exercicies.tokio.activies.five.Key.HABILITY;
import codes.exercicies.tokio.activies.five.Key.NAME_PLAYER;

public class Person {
	public NAME_PLAYER name;
	public HABILITY hability;
	public int power;
	
	public Person(NAME_PLAYER name, HABILITY hability, int power) {
		super();
		this.name = name;
		this.hability = hability;
		this.power = power;
	}
}
