package tokioschool.java.dao.controller;

import tokioschool.java.dao.daos.IPokemonDao;
import tokioschool.java.dao.daos.PokemonDaoImpl;

public class Run {
	
	public static void main(String[] args) {
		System.out.println("start");
		IPokemonDao dao = new PokemonDaoImpl();
		dao.load();
		// search all
		dao.showAll();
		// search by name
		System.out.println("Pikachu estas: "+dao.isPresent("pikachu"));
		System.out.println("end");
	}
}
