package codes.exercicies.tokio.activies.five;

import java.util.Date;

public class Save {
	public Date time;
	public Game game;
	public Back bk;
	
	public Save(Date date, Game game, Back bk) {
		super();
		this.time = date;
		this.game = game;
		this.bk = bk;
	}
}
