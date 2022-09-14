package codes.exercicies.tokio.activies.five;

public class Game {
	public Player player;
	public Screen screen;
	public Combination combination;

	public Game(Player player, Screen screen, Combination combination) {
		super();
		this.player = player;
		this.screen = screen;
		this.combination = combination;
	}
}
