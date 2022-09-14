package codes.exercicies.tokio.activies.five;

import codes.exercicies.tokio.activies.five.Key.HABILITY;
import codes.exercicies.tokio.activies.five.Key.NAME_PLAYER;

public class Player extends Person {
	private int live;
	private double point;
	
	public Player(NAME_PLAYER name, HABILITY hability, int live, double point, int power) {
		super(name, hability, power);
		this.live = live;
		this.point = point;
	}
	
	
}
