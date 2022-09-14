package codes.exercicies.tokio.activies.five;

import codes.exercicies.tokio.activies.five.Key.HABILITY;
import codes.exercicies.tokio.activies.five.Key.NAME_PLAYER;
import codes.exercicies.tokio.activies.five.Key.SCREEN;

public class Opponent extends Person {

	private Screen screen;
	private short show;  //Numero de intentos fallidos
	
	public Opponent(NAME_PLAYER name, HABILITY hability, Screen screen, short show, int power) {
		super(name, hability, power);
		this.screen = screen;
		this.show = show;
	}
	
	

}
