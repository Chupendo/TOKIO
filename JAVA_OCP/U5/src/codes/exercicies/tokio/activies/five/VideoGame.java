package codes.exercicies.tokio.activies.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import codes.exercicies.tokio.activies.five.Key.HABILITY;
import codes.exercicies.tokio.activies.five.Key.NAME_PLAYER;
import codes.exercicies.tokio.activies.five.Key.OBJECT;
import codes.exercicies.tokio.activies.five.Key.SCREEN;

public class VideoGame {
	
	
 	public static void main(String[] args) {
 		List<Combination> lCombination = new ArrayList<Combination>();
 		 	 	
 	 	lCombination.add(new Combination(Key.OBJECT.baya, Key.OBJECT.agua, Key.OBJECT.pocion, 2));
 	 	lCombination.add(new Combination(Key.OBJECT.baya, Key.OBJECT.agua, Key.OBJECT.pocion, 2));
 	 	
 	 	Player pl = new Player(Key.NAME_PLAYER.DOM, Key.HABILITY.ascuas, 300, 3,30);
 	 	
 	 	List<OBJECT> lObject = Arrays.asList(Key.OBJECT.agua,Key.OBJECT.baya);
 	 	Opponent op = new Opponent(Key.NAME_PLAYER.BUCK, Key.HABILITY.impactrueno,new Screen(lObject),(short)3,25);
 	 	
 	 	Map<OBJECT, Integer> obj = new HashMap<>();
 	 	obj.put(Key.OBJECT.agua, 3);
 	 	obj.put(Key.OBJECT.baya, 2);
 	 	obj.put(lCombination.get(1).obj3, 1);
 	 	
 	 	Back back = new Back(1, obj);
 	 	Game gm = new Game(pl, new Screen(lObject),lCombination.get(1));
 	 	Save sv = new Save(new Date(), gm, back);
 	 	
 	 	
 	 	System.out.println("Partida guardad: ");
 	 	System.out.println(sv.time+", "+sv.game.player.name);
 	 	
 
	}
}
