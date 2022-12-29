package simple;

import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Simple {
	public int sum(int a, int b) {
		return a+b;
	}
	
	public int diff(int a, int b) {
		return a-b;
	}
	
	public int randInt() {
		Date date = new Date(System.currentTimeMillis());
		Logger log = Logger.getLogger("Simple");
		log.log(Level.INFO, "randInt");
		return (int) Math.random();
	}
}
