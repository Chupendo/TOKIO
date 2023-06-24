package tokioschool.java.dao.daos;

import tokioschool.java.dao.models.Pokemon;

public interface IPokemonDao {
	boolean isPresent(String name);
	boolean add(Pokemon pokemon);
	boolean remove(Pokemon pokemon);
	void showAll();
	boolean load();
}
